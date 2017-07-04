package gr.uoa.di.controllers;

import gr.uoa.di.entities.ProviderMetadata;
import gr.uoa.di.repositories.ProviderMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;

@Controller
public class HomeController {
    private static final String imagedir = System.getProperty("user.dir") + "/src/main/webapp/assets/imagedir/";
    final private static int topProviders = 4;

    @Autowired
    private ProviderMetadataRepository mProviderRepository;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        List<ProviderMetadata> provs = mProviderRepository.findTop4ByOrderByNumberOfRatingsDesc();

        String contactus = "ompampassas@ompampassas.com";//δυναμικα
        mav.addObject("contactus", contactus);

        //store topProviders provider emails + ratings + image paths
        Info[] attributes = new Info[topProviders];

        int count = 0;
        File folder = new File(imagedir);

        for (ProviderMetadata prov : provs) {
            String email = prov.getUserByUserId().getEmail();
            int rat = 0;
            if (prov.getNumberOfRatings() != 0) {
                rat = prov.getRating() / prov.getNumberOfRatings();
            }
            String image;
            File provDir = new File(folder, email);
            if (provDir.exists() && provDir.listFiles().length != 0) {
                File[] provimage = provDir.listFiles();
                image = "imagedir/" + email + "/" + provimage[0].getName();
            } else {
                image = "images/defaultprof.png";
            }

            Info info = new Info();
            info.setProviderName(email);
            info.setProviderRating(rat);
            info.setFinalPic(image);
            info.setTitle(prov.getTitle());
            info.setNumOfRatings(prov.getNumberOfRatings());

            attributes[count] = info;
            if (++count == topProviders) break;
        }

        mav.addObject("attributes", attributes);

        return mav;
    }

    public class Info {
        String providerName;
        Integer providerRating;
        String finalPic;
        String title;
        int numOfRatings;

        public String getProviderName() {
            return providerName;
        }

        void setProviderName(String providerName) {
            this.providerName = providerName;
        }

        public Integer getProviderRating() {
            return providerRating;
        }

        void setProviderRating(Integer providerRating) {
            this.providerRating = providerRating;
        }

        public String getFinalPic() {
            return finalPic;
        }

        void setFinalPic(String finalPic) {
            this.finalPic = finalPic;
        }

        public String getTitle() {
            return title;
        }

        void setTitle(String title) {
            this.title = title;
        }

        public int getNumOfRatings() {
            return numOfRatings;
        }

        void setNumOfRatings(int numOfRatings) {
            this.numOfRatings = numOfRatings;
        }
    }
}