
package com.di.penopllast.vklikesremover.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RootFaveGetPost {

    @SerializedName("response")
    @Expose
    private ResponseFaveGetPosts response;

    public ResponseFaveGetPosts getResponse() {
        return response;
    }

    public void setResponse(ResponseFaveGetPosts response) {
        this.response = response;
    }

}
