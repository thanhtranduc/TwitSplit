package com.thanh.twitsplit.data.entity.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.thanh.twitsplit.data.entity.MessageEntity;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

/**
 * Class used to transform from Strings representing json to valid objects.
 */
public class MessEntityJsonMapper {

    private final Gson gson;

    @Inject
    public MessEntityJsonMapper() {
        this.gson = new Gson();
    }

    /**
     * Transform from valid json string to {@link MessageEntity}.
     *
     * @param userJsonResponse A json representing a user profile.
     * @return {@link MessageEntity}.
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    public MessageEntity transformUserEntity(String userJsonResponse) throws JsonSyntaxException {
        final Type userEntityType = new TypeToken<MessageEntity>() {
        }.getType();
        return this.gson.fromJson(userJsonResponse, userEntityType);
    }

    /**
     * Transform from valid json string to List of {@link MessageEntity}.
     *
     * @param userListJsonResponse A json representing a collection of users.
     * @return List of {@link MessageEntity}.
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    public List<MessageEntity> transformUserEntityCollection(String userListJsonResponse)
            throws JsonSyntaxException {
        final Type listOfUserEntityType = new TypeToken<List<MessageEntity>>() {
        }.getType();
        return this.gson.fromJson(userListJsonResponse, listOfUserEntityType);
    }
}
