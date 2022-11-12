package com.accountBook.basicBoard.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeEntity {
    @Column(nullable = false)
    private LocalDateTime insertDate;
    @Column(nullable = false)
    private LocalDateTime updateDate;
}
