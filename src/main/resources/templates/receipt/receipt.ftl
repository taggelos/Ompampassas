<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div bgcolor='#e4e4e4' text='#ff6633' link='#666666' vlink='#666666' alink='#ff6633'
     style='margin:0;font-family:Arial,Helvetica,sans-serif;border-bottom:1'>
    <table background='' bgcolor='#e4e4e4' width='100%' style='padding:20px 0 20px 0' cellspacing='0' border='0'
           align='center' cellpadding='0'>
        <tbody>
        <tr>
            <td>
                <table width='620' border='0' align='center' cellpadding='0' cellspacing='0' bgcolor='#FFFFFF'
                       style='border-radius: 5px;'>
                    <tbody>
                    <tr>
                        <td>
                            <table width='620' border='0' cellspacing='0' cellpadding='0'
                                   style='border-bottom:solid 1px #e5e5e5'>
                                <tbody>
                                <tr>
                                    <td align='left' valign='top' style='padding:0px 5px 0px 5px'>
                                        <table height='20px' width='100%' border='0' cellpadding='0' cellspacing='0'>
                                            <tbody>
                                            <tr>
                                                <td height='10px' valign='top'
                                                    style='color:#404041;font-size:13px;padding:5px 5px 0px 20px'>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign='top'
                                                    style='color:#404041;font-size:13px;padding:5px 5px 0px 20px'>
                                                    <strong>Ημερομηνία:</strong>
                                                ${event.getStartTime()}
                                                </td>
                                            </tr>
                                            <tr>
                                                <td height='16' valign='top'
                                                    style='color:#404041;font-size:13px;padding:5px 5px 0px 20px'>
                                                    <strong>Email:</strong>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign='top'
                                                    style='color:#404041;font-size:12px;padding:5px 5px 0px 20px'>
                                                    <p>
                                                        <a href='mailto:info@preview.co.za'>${event.getProviderMetadataByProviderId().getUserByUserId().getEmail()}</a><br>
                                                    </p>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </td>
                                    <td align='left' valign='top' style='padding:0px 5px 0px 5px'>
                                        <table height='146' width='100%' border='0' cellpadding='3' cellspacing='3'
                                               style='border-right:solid 1px #e5e5e5'>
                                            <tbody>
                                            <tr>
                                                <td height='16' valign='top'
                                                    style='color:#404041;font-size:13px;padding:15px 5px 0px 5px'>
                                                    <strong>Διεύθυνση Εταιρίας:</strong>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign='top'
                                                    style='color:#404041;font-size:12px;padding:0px 5px 0px 5px'>
                                                    <p>
                                                    ${event.getPlaceByPlaceId().getTitle()}<br>
                                                    ${event.getPlaceByPlaceId().getAddress()}<br>
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td height='16' valign='top'
                                                    style='color:#404041;font-size:13px;padding:0px 5px 0px 5px'>
                                                    <strong>Τηλέφωνο:</strong>

                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign='top'
                                                    style='color:#404041;font-size:12px;padding:0px 5px 0px 5px'>
                                                    <p>
                                                        <a href='tel:${event.getProviderMetadataByProviderId().getPhone()}'
                                                           target='_blank'>${event.getProviderMetadataByProviderId().getPhone()}</a><br>
                                                    </p>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </td>
                                    <td align='left' valign='top' style='padding:0px 5px 0px 5px'>
                                        <table height='146' width='100%' border='0' cellpadding='3' cellspacing='3'>
                                            <tbody>
                                            <tr>
                                                <td height='16' valign='top'
                                                    style='color:#404041;font-size:13px;padding:15px 5px 0px 5px'>
                                                    <strong>Παραγγελία από:</strong>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign='top'
                                                    style='color:#404041;font-size:12px;padding:0px 5px 0px 5px'>
                                                    <p>
                                                    ${currentUser.parentMetadataById.firstName}<br>
                                                    ${currentUser.parentMetadataById.lastName}<br>
                                                        <br>
                                                    </p>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td valign='top' style='color:#404041;line-height:16px;padding:25px 20px 0px 20px'>
                            <p>
                                <section
                                        style='position: relative;clear: both;margin: 5px 0;height: 1px;border-top: 1px solid #cbcbcb;margin-bottom: 25px;margin-top: 10px;text-align: center;'>
                                    <h3 align='center'
                                        style='margin-top: -12px;background-color: #FFF;clear: both;width: 180px;margin-right: auto;margin-left: auto;padding-left: 15px;padding-right: 15px; font-family: arial,sans-serif;'>
                                        <span>ΑΠΟΔΕΙΞΗ</span>
                                    </h3>
                                </section>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td valign='top'
                            style='color:#404041;font-size:12px;line-height:16px;padding:25px 20px 0px 20px'>
                            <p>
                                <span><h2 style='color: #848484; font-family: arial,sans-serif; font-weight: 200;'>Χαιρετισμούς από την Ompampassas,</h2></span>
                            </p>
                            <p>
                                Ευχαριστούμε για την συνεργασία σας με την <a
                                    href='/profile/${event.getProviderMetadataByProviderId().getUserByUserId().getEmail()}'
                                    target='_blank'>${event.getProviderMetadataByProviderId().getCompanyName()}</a>.<br>
                                <br>Λάβαμε την παραγγελία σας και θα σας ενημερώσουμε μόλις λάβουμε την πληρωμή σας.
                            </p>
                        </td>
                    </tr>

                    <tr>
                        <td style='color:#404041;font-size:12px;line-height:16px;padding:10px 16px 20px 18px'>
                            <table width='100%' border='0' cellpadding='0' cellspacing='0'
                                   style='border-radius:5px;border:solid 1px #e5e5e5'>
                                <tbody>
                                <tr>
                                    <td>
                                        <table width='570' border='0' cellspacing='0' cellpadding='0'>
                                            <tbody>
                                            <tr>
                                                <td width='15'> 
                                                </td>
                                                <td colspan='5' align='left' valign='top'
                                                    style='color:#404041;font-size:12px;line-height:16px;padding:5px 10px 3px 5px;border-bottom:solid 1px #e5e5e5'>
                                                    <strong>Εκδήλωση</strong>
                                                </td>
                                                <td width='85' align='right'
                                                    style='color:#404041;font-size:12px;line-height:16px;padding:5px 10px 3px 5px;border-bottom:solid 1px #e5e5e5'>
                                                    <strong>Πλήθος Εισιτηρίων</strong>
                                                </td>
                                                <td width='60' align='right'
                                                    style='color:#404041;font-size:12px;line-height:16px;padding:5px 10px 3px 5px;border-bottom:solid 1px #e5e5e5'>
                                                    <strong>Σύνολο</strong>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width='15'> 
                                                </td>
                                                <td colspan='5' align='left' valign='top'
                                                    style='color:#404041;font-size:12px;line-height:16px;padding:5px 5px 3px 5px;border-bottom:dashed 1px #e5e5e5'>
                                                ${event.getTitle()}
                                                </td>
                                                <td width='85' align='right' valign='top'
                                                    style='color:#404041;font-size:12px;line-height:16px;padding:5px 5px 3px 5px;border-bottom:dashed 1px #e5e5e5'>
                                                ${ticket.getNumOfTickets()}
                                                </td>
                                                <td width='60' align='right' valign='top'
                                                    style='color:#404041;font-size:12px;line-height:16px;padding:5px 5px 3px 5px;border-bottom:dashed 1px #e5e5e5'>
                                                ${event.getPrice() * ticket.getNumOfTickets()}
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width='15'> 
                                                </td>
                                                <td width='100' align='left' valign='top'
                                                    style='color:#404041;font-size:12px;padding:10px 0px 0px 5px'>
                                                    <strong>Πάροχος:</strong>
                                                </td>
                                                <td colspan='4' align='left' valign='top' width='115'
                                                    style='color:#ff6600;font-size:12px;padding:10px 5px 0px 5px'>
                                                    <a href='/profile/${event.getProviderMetadataByProviderId().getUserByUserId().getEmail()}'
                                                       target='_blank'>${event.getProviderMetadataByProviderId().getCompanyName()}</a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width='15'> 
                                                </td>
                                                <td width='100' align='left' valign='top'
                                                    style='color:#404041;font-size:12px;padding:5px 5px 0px 5px'>
                                                    <strong>Περιγραφή:</strong>
                                                </td>
                                                <td colspan='4' align='left' valign='top'
                                                    style='color:#404041;font-size:12px;padding:5px 5px 0px 5px'>
                                                ${event.getDescription()}
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr align='left'>
                        <td style='color:#404041;font-size:12px;line-height:16px;padding:10px 16px 20px 18px'>
                            <table width='0' border='0' align='left' cellpadding='0' cellspacing='0'>
                                <span><h2 style='color: #848484; font-family: arial,sans-serif; font-weight: 200;'>Banking Details</h2></span>
                                <tbody>
                                <tr>
                                    <td width='0' align='left' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:0px 0px 3px 0px'>
                                        <strong>Bank:</strong>
                                    </td>
                                    <td width='0' align='right' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:0px 5px 3px 5px'>
                                        Bank 1
                                    </td>
                                </tr>
                                <tr>
                                    <td align='left' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 0px 3px 0px;'>
                                        <strong>Account Number:</strong>
                                    </td>
                                    <td width='62' align='right' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 5px 3px 5px;'>
                                        123456789
                                    </td>
                                </tr>
                                <tr>
                                    <td align='left' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 0px 3px 0px;'>
                                        <strong>Branch:</strong>
                                    </td>
                                    <td width='120' align='right' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 5px 3px 5px;'>
                                        Bank Area
                                    </td>
                                </tr>
                                </tbody>
                                <tbody>
                                <tr>
                                    <td width='0' align='left' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:15px 0px 3px 0px'>
                                        <strong>Bank:</strong>
                                    </td>
                                    <td width='0' align='right' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:15px 5px 3px 5px'>
                                        Bank 2
                                    </td>
                                </tr>

                                <tr>
                                    <td align='left' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 0px 3px 0px;'>
                                        <strong>Account Number:</strong>
                                    </td>
                                    <td width='62' align='right' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 5px 3px 5px;'>
                                        123456789
                                    </td>
                                </tr>
                                <tr>
                                    <td align='left' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 0px 3px 0px;'>
                                        <strong>Branch:</strong>
                                    </td>
                                    <td width='120' align='right' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 5px 3px 5px;'>
                                        Bank Branch
                                    </td>
                                </tr>
                                </tbody>
                                <tbody>
                                <tr>
                                    <td width='0' align='left' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:15px 0px 3px 0px'>
                                        <strong>Bank:</strong>
                                    </td>
                                    <td width='0' align='right' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:15px 5px 3px 5px'>
                                        Bank 3
                                    </td>
                                </tr>

                                <tr>
                                    <td align='left' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 0px 3px 0px;'>
                                        <strong>Account Number:</strong>
                                    </td>
                                    <td width='62' align='right' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 5px 3px 5px;'>
                                        123456789
                                    </td>
                                </tr>
                                <tr>
                                    <td align='left' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 0px 3px 0px;'>
                                        <strong>Branch:</strong>
                                    </td>
                                    <td width='120' align='right' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 5px 3px 5px;'>
                                        Bank Branch
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <table width='0' border='0' align='right' cellpadding='0' cellspacing='0'>
                                <tbody>
                                <tr>
                                    <td width='0' align='left' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:15px 0px 3px 0px'>
                                        <strong>VAT</strong>
                                    </td>
                                    <td width='0' align='right' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:15px 5px 3px 5px'>
                                        124.00€
                                    </td>
                                </tr>
                                <tr>
                                    <td width='0' align='left' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:15px 0px 3px 0px'>
                                        <strong>Sub-total:</strong>
                                        <span style='font-size:11px;color:#666666'>(VAT included)</span>
                                    </td>
                                    <td width='0' align='right' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:15px 5px 3px 5px'>
                                        1356.00€
                                    </td>
                                </tr>
                                <tr>
                                    <td align='left' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 0px 3px 0px'>
                                        <strong>Delivery costs:</strong>
                                    </td>
                                    <td width='62' align='right' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 5px 3px 5px'>
                                        0.00€
                                    </td>
                                </tr>
                                <tr>
                                    <td align='left' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 0px 3px 0px;border-bottom:solid 1px #999999'>
                                        <strong>Order discount:</strong>
                                    </td>
                                    <td width='62' align='right' valign='top'
                                        style='color:#404041;font-size:12px;line-height:16px;padding:5px 5px 3px 5px;border-bottom:solid 1px #999999'>
                                        0.00€
                                    </td>
                                </tr>
                                <tr>
                                    <td align='left' valign='bottom'
                                        style='color:#404041;font-size:13px;line-height:16px;padding:5px 0px 3px 0px'>
                                        <strong>Grand Total:</strong>
                                    </td>
                                    <td width='62' align='right' valign='bottom'
                                        style='color:#339933;font-size:13px;line-height:16px;padding:5px 5px 3px 5px'>
                                        <strong>${event.getPrice() * ticket.getNumOfTickets()}€</strong>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table width='550' border='0' cellspacing='0' cellpadding='0'>
                                <tbody>
                                <tr>
                                    <td style='color:#404041;font-size:12px;line-height:16px;padding:15px 5px 5px 10px'>
                                        Για περισσότερες πληροφορίες σχετικά με την παραγγελία σας επικοινωνήστε μαζί
                                        μας στο <strong> <a href='tel:694 822 9368' value='+694 822 9368'
                                                            target='_blank'>694 822 9368</a></strong>, ή στείλτε μας
                                        email στο
                                        <a href='mailto:ompampassas@ompampassas.com'>ompampassas@ompampassas.com</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table width='510' border='0' cellspacing='0' cellpadding='0'>
                                <tbody>
                                <tr>
                                    <td style='color:#404041;font-size:12px;line-height:16px;padding:5px 15px 10px 10px'>
                                        <p>
                                            Με εκτίμηση,<br>
                                            <strong> <a href='#' target='_blank'>Ompampassas</a></strong>
                                        </p>
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
