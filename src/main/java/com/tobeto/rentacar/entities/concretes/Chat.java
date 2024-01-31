package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.concretes.enums.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Chat {

    private MessageType type;
    private String content;
    private String sender;
}
