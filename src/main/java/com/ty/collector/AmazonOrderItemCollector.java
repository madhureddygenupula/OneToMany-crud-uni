package com.ty.collector;

import java.util.ArrayList;
import java.util.List;

import com.ty.dao.AmazonOrderItem;
import com.ty.dto.AmazonOrder;
import com.ty.dto.Item;

public class AmazonOrderItemCollector {
	public static void main(String[] args) {
		Item item=new Item();
		item.setId(1);
		item.setName("Bag");
		item.setPrice(562.0);
		item.setQuantity(1);
		
		Item item1=new Item();
		item1.setId(2);
		item1.setName("Book");
		item1.setPrice(100.0);
		item1.setQuantity(4);
		
		Item item2=new Item();
		item2.setId(3);
		item2.setName("Pen");
		item2.setPrice(20.0);
		item2.setQuantity(1);
		List<Item> items=new ArrayList<Item>();
		items.add(item);
		items.add(item1);
		
		AmazonOrder amazonOrder=new AmazonOrder();
		amazonOrder.setId(101);
		amazonOrder.setAddess("JPNagar");
		amazonOrder.setItems(items);
		AmazonOrderItem amazonOrderItem=new AmazonOrderItem();
		amazonOrderItem.save(amazonOrder);
	}
}
