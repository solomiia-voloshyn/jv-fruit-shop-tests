package core.basesyntax.strategy;

import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.OperationHandlerStrategyImpl;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BalanceHandlerTest {
    private static Map<String, OperationHandler> operationHandler;
    private static OperationHandler balanceHandler;

    @BeforeClass
    public static void setUp() {
        balanceHandler = new BalanceHandler();
        operationHandler = new HashMap<>();
        operationHandler.put("b", new BalanceHandler());
        new OperationHandlerStrategyImpl(operationHandler);
    }

    @Test
    public void balanceHandler_ok() {
        int balance = 100;
        int quality = 10;
        int balanceResult = balance + quality;
        int actual = balanceHandler.handle(balance,quality);
        int expected = balanceResult;
        Assert.assertEquals(expected, actual);
    }
}
