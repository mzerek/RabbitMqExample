package com.mzerek.producer_service.mzerekproducer.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
public class Animal implements Serializable {

    String id;
    String name;
}
