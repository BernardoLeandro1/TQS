package stocks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.Is.is;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;


/**
 * Unit test for StockPortfolio.
 */

@ExtendWith(MockitoExtension.class)
public class StockPortfolioTest {

    private StockPortfolio portfolio;

    @Mock
    IStockmarketService service;

    @BeforeEach
    public void setUp() {
        portfolio = new StockPortfolio(service);

        when(service.lookUpPrice("shirt")).thenReturn(10.0);
        when(service.lookUpPrice("shorts")).thenReturn(15.0);
    }

    @Test
    public void testTotalValue() {

        portfolio.addStock(new Stock("shirt", 20));
        portfolio.addStock(new Stock("shorts", 20));

        assertThat(portfolio.getTotalValue(), is(500.0));

    }
}
