package com.mon0mon.makingcleanarchitecture.application.domain;

import com.mon0mon.makingcleanarchitecture.application.domain.model.ActivityWindow;
import com.mon0mon.makingcleanarchitecture.application.domain.model.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.mon0mon.makingcleanarchitecture.application.domain.model.Account.*;
import static com.mon0mon.makingcleanarchitecture.common.ActivityTestData.defaultActivity;


class ActivityWindowTest {

    @Test
    void calculatesStartTimestamp() {
        ActivityWindow window = new ActivityWindow(
                defaultActivity().withTimestamp(startDate())
                                 .build(),
                defaultActivity().withTimestamp(inBetweenDate())
                                 .build(),
                defaultActivity().withTimestamp(endDate())
                                 .build());

        Assertions.assertThat(window.getStartTimestamp())
                  .isEqualTo(startDate());
    }

    @Test
    void calculatesEndTimestamp() {
        ActivityWindow window = new ActivityWindow(
                defaultActivity().withTimestamp(startDate())
                                 .build(),
                defaultActivity().withTimestamp(inBetweenDate())
                                 .build(),
                defaultActivity().withTimestamp(endDate())
                                 .build());

        Assertions.assertThat(window.getEndTimestamp())
                  .isEqualTo(endDate());
    }

    @Test
    void calculatesBalance() {

        AccountId account1 = new AccountId(1L);
        AccountId account2 = new AccountId(2L);

        ActivityWindow window = new ActivityWindow(
                defaultActivity()
                        .withSourceAccount(account1)
                        .withTargetAccount(account2)
                        .withMoney(Money.of(999))
                        .build(),
                defaultActivity()
                        .withSourceAccount(account1)
                        .withTargetAccount(account2)
                        .withMoney(Money.of(1))
                        .build(),
                defaultActivity()
                        .withSourceAccount(account2)
                        .withTargetAccount(account1)
                        .withMoney(Money.of(500))
                        .build());

        Assertions.assertThat(window.calculateBalance(account1))
                  .isEqualTo(Money.of(-500));
        Assertions.assertThat(window.calculateBalance(account2))
                  .isEqualTo(Money.of(500));
    }

    private LocalDateTime startDate() {
        return LocalDateTime.of(2019, 8, 3, 0, 0);
    }

    private LocalDateTime inBetweenDate() {
        return LocalDateTime.of(2019, 8, 4, 0, 0);
    }

    private LocalDateTime endDate() {
        return LocalDateTime.of(2019, 8, 5, 0, 0);
    }

}
