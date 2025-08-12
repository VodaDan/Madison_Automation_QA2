package pages;

import com.microsoft.playwright.Page;
import models.DeliveryAddress;
import models.User;

public class CheckoutPage {

    private Page page;

    // Billing form selectors variables
    private String firstNameSelector;
    private String lastNameSelector;
    private String emailSelector;
    private String phoneSelector;
    private String citySelector;
    private String zipSelector;
    private String addressSelector;
    private String regionSelector;

    // Shipping form selectors variables
    private String firstNameShippingSelector;
    private String lastNameShippingSelector;
    private String emailShippingSelector;
    private String phoneShippingSelector;
    private String cityShippingSelector;
    private String zipShippingSelector;
    private String addressShippingSelector;
    private String regionShippingSelector;

    private String continueBillingButton;
    private String checkoutOnePageCheckoutContinueButton;
    private String checkoutShipDifferentAddressButton;


    public CheckoutPage(Page pageSent) {
        page = pageSent;

        // Billing form Selectors
        firstNameSelector="#billing\\:firstname";
        lastNameSelector="#billing\\:lastname";
        emailSelector="#billing\\:email";
        addressSelector="#billing\\:street1";
        zipSelector="#billing\\:postcode";
        citySelector="#billing\\:city";
        phoneSelector="#billing\\:telephone";
        regionSelector="#billing\\:region_id";
        continueBillingButton="div.fieldset button";
        checkoutOnePageCheckoutContinueButton = "#onepage-guest-register-button";
        checkoutShipDifferentAddressButton = "label[for='billing\\:use_for_shipping_no']";

        // Shipping form selectors
        firstNameShippingSelector="#shipping\\:firstname";
        lastNameShippingSelector="#shipping\\:lastname";
        emailShippingSelector="#shipping\\:email";
        phoneShippingSelector="#shipping\\:telephone";
        cityShippingSelector="#shipping\\:city";
        zipShippingSelector="#shipping\\:postcode";
        addressShippingSelector="#shipping\\:street1";
        regionShippingSelector="#shipping\\:region_id";
    }

    // Billing form methods

    public void fillFirstName(String firstName) {
        page.locator(firstNameSelector).fill(firstName);
    }

    public void fillEmail(String email) {
        page.locator(emailSelector).fill(email);
    }

    public void fillAddress(String address) {
        page.locator(addressSelector).fill(address);
    }

    public void fillCity(String city) {
        page.locator(citySelector).fill(city);
    }

    public void fillZip(String zip) {
        page.locator(zipSelector).fill(zip);
    }

    public void fillPhone(String phone){
        page.locator(phoneSelector).fill(phone);
    }

    public void fillLastName(String lastname) {
        page.locator(lastNameSelector).fill(lastname);
    }

    public void fillRegion(String region) {
        page.locator(regionSelector).selectOption(region);
    }

    public void fillRegion() {
        page.locator(regionSelector).selectOption("Alaska");
    }

    public void fillCheckoutFormBilling(DeliveryAddress testAddress) {
        fillFirstName(testAddress.getFirstName());
        fillLastName(testAddress.getFirstName());
        fillEmail(testAddress.getEmail());
        fillAddress(testAddress.getAddress());
        fillCity(testAddress.getCity());
        fillPhone(testAddress.getPhone());
        fillZip(testAddress.getZip());
    }

    public void fillFirstNameShipping(String firstName) {
        page.locator(firstNameShippingSelector).fill(firstName);
    }

    public void fillEmailShipping(String email) {
        page.locator(emailShippingSelector).fill(email);
    }

    public void fillAddressShipping(String address) {
        page.locator(addressShippingSelector).fill(address);
    }

    public void fillCityShipping(String city) {
        page.locator(cityShippingSelector).fill(city);
    }

    public void fillZipShipping(String zip) {
        page.locator(zipShippingSelector).fill(zip);
    }

    public void fillPhoneShipping(String phone){
        page.locator(phoneShippingSelector).fill(phone);
    }

    public void fillLastNameShipping(String lastname) {
        page.locator(lastNameShippingSelector).fill(lastname);
    }

    public void fillRegionShipping(String region) {
        page.locator(regionShippingSelector).selectOption(region);
    }

    public void fillRegionShipping() {
        page.locator(regionShippingSelector).selectOption("Alaska");
    }

    public void fillCheckoutFormShipping(DeliveryAddress testAddress) {
        fillFirstNameShipping(testAddress.getFirstName());
        fillLastNameShipping(testAddress.getFirstName());
        fillEmailShipping(testAddress.getEmail());
        fillAddressShipping(testAddress.getAddress());
        fillCityShipping(testAddress.getCity());
        fillPhoneShipping(testAddress.getPhone());
        fillZipShipping(testAddress.getZip());
    }

    // Shipping form methods

    public void continueCheckout() {
        page.locator(continueBillingButton).click();
    }

    public void checkoutClickOnePageContinueButton() {
        page.locator(checkoutOnePageCheckoutContinueButton).click();
    }

    public void checkoutShipDifferentAddress() {
        page.locator(checkoutShipDifferentAddressButton).click();
    }

    public String getFirstNameSelector() {
        return firstNameSelector;
    }

    public void setFirstNameSelector(String firstNameSelector) {
        this.firstNameSelector = firstNameSelector;
    }

    public String getLastNameSelector() {
        return lastNameSelector;
    }

    public void setLastNameSelector(String lastNameSelector) {
        this.lastNameSelector = lastNameSelector;
    }

    public String getEmailSelector() {
        return emailSelector;
    }

    public void setEmailSelector(String emailSelector) {
        this.emailSelector = emailSelector;
    }

    public String getPhoneSelector() {
        return phoneSelector;
    }

    public void setPhoneSelector(String phoneSelector) {
        this.phoneSelector = phoneSelector;
    }

    public String getCitySelector() {
        return citySelector;
    }

    public void setCitySelector(String citySelector) {
        this.citySelector = citySelector;
    }

    public String getZipSelector() {
        return zipSelector;
    }

    public void setZipSelector(String zipSelector) {
        this.zipSelector = zipSelector;
    }

    public String getAddressSelector() {
        return addressSelector;
    }

    public void setAddressSelector(String addressSelector) {
        this.addressSelector = addressSelector;
    }

    public String getRegionSelector() {
        return regionSelector;
    }

    public void setRegionSelector(String regionSelector) {
        this.regionSelector = regionSelector;
    }

    public String getContinueButton() {
        return continueBillingButton;
    }
}
