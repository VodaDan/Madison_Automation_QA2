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

    // Buttons
    private String continueBillingButton;
    private String checkoutOnePageCheckoutContinueButton;
    private String checkoutShipDifferentAddressButton;
    private String continueShippingButton;
    private String continuePayment;
    private String continueShippingPrice;
    private String placeOrderButton;

    // Others
    private String freeShipping;
    private String flatRate;
    private String checkoutLoginEmail;
    private String checkoutLoginPassword;
    private String checkoutLoginButton;



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

        // Buttons
        continueBillingButton="div.fieldset button";
        continueShippingButton = "div#shipping-buttons-container>button";
        checkoutOnePageCheckoutContinueButton = "#onepage-guest-register-button";
        checkoutShipDifferentAddressButton = "label[for='billing\\:use_for_shipping_no']";
        continuePayment = "div#payment-buttons-container > button";
        continueShippingPrice = "div#shipping-method-buttons-container button";
        placeOrderButton = "div#review-buttons-container button";

        // Shipping form selectors
        firstNameShippingSelector="#shipping\\:firstname";
        lastNameShippingSelector="#shipping\\:lastname";
        phoneShippingSelector="#shipping\\:telephone";
        cityShippingSelector="#shipping\\:city";
        zipShippingSelector="#shipping\\:postcode";
        addressShippingSelector="#shipping\\:street1";
        regionShippingSelector="select#shipping\\:region_id";

        // Others
        freeShipping = "input#s_method_freeshipping_freeshipping";
        flatRate = "input#s_method_freeshipping_freeshipping";
        checkoutLoginButton = "div.buttons-set button[type='submit']";
        checkoutLoginEmail = "#login-email";
        checkoutLoginPassword = "#login-password";

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

    // Shipping form methods

    public void fillFirstNameShipping(String firstName) {
        page.locator(firstNameShippingSelector).fill(firstName);
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
        fillAddressShipping(testAddress.getAddress());
        fillCityShipping(testAddress.getCity());
        fillPhoneShipping(testAddress.getPhone());
        fillZipShipping(testAddress.getZip());
        fillRegionShipping();
    }

    public void clickContinueShipping() {
        page.locator(continueShippingButton).click();
    }

    public void selectRate(String rate) {
        if(rate.contains("free")) {
            page.locator(freeShipping).click();
        } else if(rate.contains("flat")||rate.contains("fixed")) {
            page.locator(flatRate).click();
        }
    }

    public void clickContinuePayment() {
        page.locator(continuePayment).click();
    }

    public void clickContinueShippingPrice() {
        page.locator(continueShippingPrice).click();
    }

    public void clickPlaceOrder() {
        page.locator(placeOrderButton).click();
    }

    public void fillCheckoutLoginEmail(String email) {
        page.locator(checkoutLoginEmail).fill(email);
    }

    public void fillCheckoutLoginPassword(String password) {
        page.locator(checkoutLoginPassword).fill(password);
    }

    public void checkoutClickLoginButton() {
        page.locator(checkoutLoginButton).click();
    }

    public void fillCheckoutLoginForm(User user) {
        fillCheckoutLoginEmail(user.getEmail());
        fillCheckoutLoginPassword(user.getPassword());
        checkoutClickLoginButton();
    }

    // ----------------------------------------------------------------------------

    public void clickContinueBilling() {
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
