package com.thanh.twitsplit.data.entity.mapper;

import com.thanh.twitsplit.data.entity.MessageEntity;
import com.thanh.twitsplit.domain.MessageTwit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class MessEntityDataMapper {

    @Inject
    public MessEntityDataMapper() {
    }

    /**
     * Transform a {@link MessageEntity} into an {@link MessageTwit}.
     *
     * @param messageEntity Object to be transformed.
     * @return {@link MessageTwit} if valid {@link MessageEntity} otherwise null.
     */
    public MessageTwit transform(MessageEntity messageEntity) {
        MessageTwit messageTwit = null;
        if (messageEntity != null) {
            messageTwit = new MessageTwit();
            messageTwit.setMessage(messageEntity.getMessage());
        }
        return messageTwit;
    }

    /**
     * Transform a List of {@link MessageEntity} into a Collection of {@link MessageTwit}.
     *
     * @param messageEntityCollection Object Collection to be transformed.
     * @return {@link MessageTwit} if valid {@link MessageEntity} otherwise null.
     */
    public List<MessageTwit> transform(Collection<MessageEntity> messageEntityCollection) {
        final List<MessageTwit> messageTwitList = new ArrayList<>(20);
        for (MessageEntity messageEntity : messageEntityCollection) {
            final MessageTwit messageTwit = transform(messageEntity);
            if (messageTwit != null) {
                messageTwitList.add(messageTwit);
            }
        }
        return messageTwitList;
    }
}
