package com.santander.apisantander.exceptions;

import com.santander.apisantander.util.MessageUtil;

public class NotFoundException extends RuntimeException {

    public NotFoundException(){
        super(MessageUtil.NO_RECORDS_FOUND);
    }
}
