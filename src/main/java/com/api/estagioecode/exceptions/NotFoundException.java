package com.api.estagioecode.exceptions;

import com.api.estagioecode.utils.MessageUtils;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
