package uts.bank;
import uts.bank.model.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


public class test {
    @Test
    public void testUser(user iop){
        assertTrue(iop != null);
    }
}
