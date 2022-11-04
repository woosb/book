package com.accountBook.basicBoard.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Data
public class TimeEntity {
    @Column(nullable = false)
    private LocalDateTime insertDate;
    @Column(nullable = false)
    private LocalDateTime updateDate;
}
