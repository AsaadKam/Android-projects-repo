package com.example.native_programmer.myfavouritsongs;

class androidMusic {


    // Name of the Singer (e.g. adele ,Micheal jachson)
    private String mSingerName;

    //  Song name(e.g rockby baby,...)
    private String mSongName;

    // Drawable resource ID
    private int mImageResourceId;

    /*
     * Create a new AndroidMusicr object.
     *
     * @param vSingerName is the name  of the Singer (e.g. adele ,Micheal jachson)
     * @param vSongName is the corresponding Song name(e.g rockby baby,...)
     * @param image is drawable reference ID that corresponds to the Android version
     * */
    public androidMusic(String vSongName, String vSingerName, int vImageResourceId) {
        mSingerName = vSingerName;
        mSongName = vSongName;
        mImageResourceId = vImageResourceId;
    }

    /**
     * Get the name  of the Singer (e.g. adele ,Micheal jachson)
     */
    public String getSingerName() {
        return mSingerName;
    }

    /**
     * Get the song name(e.g rockby baby,...)
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }


}
