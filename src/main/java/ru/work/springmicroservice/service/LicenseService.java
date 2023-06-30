package ru.work.springmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.work.springmicroservice.model.License;

import java.util.Locale;
import java.util.Random;



@Service
public class LicenseService {
    @Autowired
    MessageSource message;

    public License getLicense(String licanseId, String organizationId) {
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licanseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");
        return license;
    }

    public String createLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
//            responseMessage = String.format("This is post and the object is:%s", license.toString());
            responseMessage = String.format(message.getMessage("license.create.message", null, locale), license.toString());
        }
        return responseMessage;
    }

    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;
        if (organizationId != null) {
            license.setOrganizationId(organizationId);
//            responseMessage = String.format("This is put and the object is:%s", license.toString());
            responseMessage = String.format(message.getMessage("license.update.message", null, null), license.toString());
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId, Locale locale) {
        String responseMessage = "";
//        responseMessage = String.format("Deleting license with id:%s for organisation %s", licenseId, organizationId);
        responseMessage = String.format(message.getMessage("license.delete.message", null, locale), licenseId, organizationId);
        return responseMessage;
    }


}
