package app.milleniuminfinity.com.milleniuminfinity.domain.shop;

import junit.framework.Assert;

import app.milleniuminfinity.com.milleniuminfinity.factories.shop.ShopFactory;

/**
 * Created by Chad on 4/24/2016.
 */
public class ShopTest{

        public void testShopFactory() throws Exception
        {
            ShopFactory shopFactoryObject = new ShopFactory();
            Shop shopObject = shopFactoryObject.getShopInstance("123", "XYZ store", "Mr T", "021 123 1234");

            Assert.assertEquals(shopObject.getShopNumber(), "123");
            Assert.assertEquals(shopObject.getShopName(), "XYZ store");
            Assert.assertEquals(shopObject.getShopOwner(), "Mr T");
            Assert.assertEquals(shopObject.getShopPhoneNumber(), "021 123 1234");
        }
}
