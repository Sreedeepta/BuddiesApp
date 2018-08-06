package com.example.yashika.buddiesapp;

public class Profile {

    /**
     * Name of friend
     */
    private String mFriendName;
    /**
     * Description about friend
     */
    private String mFriendDesc;
    /**
     * Image resource ID for friend's picture
     */
    private int mImageResourceId;


    /**
     * Create a new Profile object.
     *
     * @param friendName      is the friend's name
     * @param friendDesc      is the name of description about friend
     * @param imageResourceId is the resource id of friend's picture
     */
    public Profile(String friendName, String friendDesc, int imageResourceId) {
        mFriendName = friendName;
        mFriendDesc = friendDesc;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the friend.
     */
    public String getFriendName() {
        return mFriendName;
    }

    /**
     * Get the description about friend.
     */
    public String getFriendDesc() {
        return mFriendDesc;
    }

    /**
     * Get the resource id of the friend's picture
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

}
