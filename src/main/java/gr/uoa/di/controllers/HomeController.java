package gr.uoa.di.controllers;

import gr.uoa.di.repositories.ProviderMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Controller
public class HomeController {
    public static final String imagedir = System.getProperty("user.dir") + "/src/main/webapp/assets/imagedir/";

    int num_of_max = 6;

    @Autowired
    private ProviderMetadataRepository mProviderRepository;

    @GetMapping("/")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("index");

        HashMap<String, Integer> hprov = new HashMap<String, Integer>();
        mProviderRepository.findAll().forEach(prov -> {
            int rat = 0;
            if (prov.getNumberOfRatings() != 0)
                rat = prov.getRating() / prov.getNumberOfRatings();
            hprov.put(prov.getUserByUserId().getEmail(), rat);

        });

        // TODO: What up with this?
        if (request.getParameter("registered") != null &&
                request.getParameter("registered").equals("1"))
            mav.addObject("registered", true);
        // ???
        String contactus = "ompampassas@ompampassas.com";//δυναμικα
        mav.addObject("contactus", contactus);
        Map.Entry<String, Integer> entry = hprov.entrySet().iterator().next();

        //store 4 provider emails + ratings
        int count = 0;
        String[] providerNames = new String[4];
        String[] providerRating = new String[4];
        Set set = hprov.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            HashMap.Entry mentry = (HashMap.Entry) iterator.next();
            //System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
            //System.out.println(mentry.getValue());
            providerNames[count] = mentry.getKey().toString();
            providerRating[count] = mentry.getValue().toString();
            if (count == 3) break;
            count++;
        }
        System.out.println(providerNames[0] + providerNames[1] + providerNames[2] + providerNames[3] + "HERE");

        //take their images

        File folder = new File(imagedir);
        File[] listOfFiles = folder.listFiles();
        System.out.println("SADS " + listOfFiles[0]);

        String providerPic = entry.getKey() + "/";
        String[] finalPics = new String[4];
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < listOfFiles.length; i++) {
                System.out.println("SADS " + listOfFiles[i]);
                if (listOfFiles[i].toPath().equals(Paths.get(imagedir + providerNames[j]))) {
                    File[] provimage = listOfFiles[i].listFiles();
                    if (provimage.length == 0) {
                        System.out.println("HERE AXNE " + providerNames[j]);
                        finalPics[j] = "-";
                    } else
                        finalPics[j] = providerNames[j] + "/" + provimage[0].getName();
                }
            }
            if (finalPics[j] == null) {
                finalPics[j] = "-";
            }
        }
        for (int i = 0; i < 4; i++) {
            if (finalPics[i].equals("-")) {
                finalPics[i] = "images/defaultprof.png";
            } else {
                finalPics[i] = "imagedir/" + finalPics[i];
            }
        }
        System.out.print(providerPic);
        mav.addObject("provider1", finalPics[0]);
        mav.addObject("provider2", finalPics[1]);
        mav.addObject("provider3", finalPics[2]);
        mav.addObject("provider4", finalPics[3]);
        mav.addObject("linkprovider1", providerNames[0]);
        mav.addObject("linkprovider2", providerNames[1]);
        mav.addObject("linkprovider3", providerNames[2]);
        mav.addObject("linkprovider4", providerNames[3]);
        mav.addObject("rating1", providerRating[0]);
        mav.addObject("rating2", providerRating[1]);
        mav.addObject("rating3", providerRating[2]);
        mav.addObject("rating4", providerRating[3]);

        mav.addObject("rating", entry.getValue());
        return mav;
    }
}