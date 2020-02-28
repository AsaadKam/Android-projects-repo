package com.example.native_programmer.tourguide;

class androidPlace {


    // Name of the place
    private String mPlaceName;

    //  Information (rate or where it exist)
    private String mInformation;

    // Drawable resource ID
    private int mImageResourceId;


    /*
     * Create a new androidplace object.
     *
     * @param vInformation is the name  of the place
     * @param vInformation is the Information
     * @param image is drawable reference ID that corresponds to the Android version
     * */
    public androidPlace(String vPlaceName, String vInformation, int vImageResourceId) {
        mPlaceName = vPlaceName;
        mInformation = vInformation;
        mImageResourceId = vImageResourceId;

    }

    /**
     * Get the name  name  of the place     */

    public String getPlaceName() {
        return mPlaceName;
    }

    /**
     * Get the information (rate or where it exist)
     */
    public String getInformationName() {
        return mInformation;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }


}
