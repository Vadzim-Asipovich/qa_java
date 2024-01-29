import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionHasManeTest {
    private final String sex;
    private final boolean expected;

    public LionHasManeTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Feline feline;
    @Parameterized.Parameters
    public static Object[][] getLionParams() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false},
        };
    }

    @Test
    public void doesHaveMane() throws Exception{
        Lion lion = new Lion(sex,feline);
        Assert.assertEquals(expected, lion.doesHaveMane());
    }
}
