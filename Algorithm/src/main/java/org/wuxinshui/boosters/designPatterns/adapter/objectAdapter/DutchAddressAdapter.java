package org.wuxinshui.boosters.designPatterns.adapter.objectAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/7
 * Time: 11:05
 * To change this template use File | Settings | File Templates.
 */
public class DutchAddressAdapter extends DutchAddress {
  private   Address address;

    public DutchAddressAdapter(Address addr){
        this.address=addr;
    }

    @Override
    public void straat() {
        address.street();
    }

    @Override
    public void postcode() {
        address.zip();
    }

    @Override
    public void plaats() {
        address.city();
    }
}
