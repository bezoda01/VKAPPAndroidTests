package api;

import io.qameta.allure.Step;
import models.PostPhotoModel;
import models.PostSendModel;
import models.ResponseModel;
import models.UploadUrlModel;
import models.requestPhotoModel.RequestPhotoModel;
import utils.APIUtils;
import utils.JsonUtils;
import java.net.URLEncoder;

import static settings.Settings.config;

public class ApiApplication {

    @Step("create post on user page {0} with message: {1}")
    public static PostSendModel publishPost(String userId, String message) {
        ResponseModel responseModel = APIUtils.getRequest(String.format(VkApi.WALL_POST.getValue(),
                userId,
                message,
                Constants.TOKEN_AND_API_VERSION));
        return JsonUtils.jsonStringToObject(responseModel.getBody(), PostSendModel.class);
    }

    @Step("delete current user {0} post {1}")
    public static boolean deletePostById(String userId, int post_id) {
        ResponseModel responseModel = APIUtils.getRequest(String.format(VkApi.WALL_DELETE.getValue(),
                userId,
                post_id,
                Constants.TOKEN_AND_API_VERSION));
        return responseModel.getBody().contains("1");
    }

    @Step("return upload url current user {0}")
    public static UploadUrlModel getUploadUrl(String userId) {
        ResponseModel responseModel = APIUtils.getRequest(String.format(VkApi.PHOTOS_GET_UPLOAD_SERVER.getValue(),
                userId,
                Constants.TOKEN_AND_API_VERSION));
        return JsonUtils.jsonStringToObject(responseModel.getBody(), UploadUrlModel.class);
    }

    @Step("upload photo on server")
    public static PostPhotoModel getPhotoAttribute(String inquiry) {
        ResponseModel responseModel = APIUtils.postUploadFile(inquiry, "photo", config.get("filePath").toString());
        return JsonUtils.jsonStringToObject(responseModel.getBody(), PostPhotoModel.class);
    }

    @Step("save photo in album")
    public static RequestPhotoModel savePhotoInAlbum(String userId, PostPhotoModel postPhotoModel) {
        ResponseModel responseModel = APIUtils.getRequest(String.format(VkApi.PHOTOS_SAVE_WALL_PHOTO.getValue(),
                userId,
                postPhotoModel.getServer(),
                URLEncoder.encode(postPhotoModel.getPhoto()),
                postPhotoModel.getHash(),
                Constants.TOKEN_AND_API_VERSION));
        return JsonUtils.jsonStringToObject(responseModel.getBody(), RequestPhotoModel.class);
    }

    @Step("edit message with photo {2} and new message {3}")
    public static ResponseModel editPostMessage(String userId, int postId, int photoId, String text) {
        ResponseModel responseModel = APIUtils.getRequest(String.format(VkApi.WALL_EDIT.getValue(),
                userId,
                postId,
                text,
                userId,
                photoId,
                Constants.TOKEN_AND_API_VERSION));
        return responseModel;
    }

    @Step("add comment on post with message {2}")
    public static ResponseModel addCommentOnPost(String userId, int postId, String message) {
        ResponseModel responseModel = APIUtils.getRequest(String.format(VkApi.WALL_CREATE_COMMENT.getValue(),
                userId,
                postId,
                message,
                Constants.TOKEN_AND_API_VERSION));
        return responseModel;
    }
}