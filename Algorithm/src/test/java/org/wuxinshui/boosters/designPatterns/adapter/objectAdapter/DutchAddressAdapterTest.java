package org.wuxinshui.boosters.designPatterns.adapter.objectAdapter;

import org.junit.Test;
import org.oasisOpen.docs.wsrf.x2004.x06.wsrfWSServiceGroup12Draft01.AddDocument;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/7
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
public class DutchAddressAdapterTest {

   private Address address = new Address();

    public DutchAddress dutchAddress = new DutchAddressAdapter(address);

    @Test
    public void straat() throws Exception {
        dutchAddress.straat();
    }

    @Test
    public void postcode() throws Exception {
        dutchAddress.postcode();
    }

    @Test
    public void plaats() throws Exception {
        dutchAddress.plaats();
    }

}