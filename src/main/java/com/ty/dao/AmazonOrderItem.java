package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.AmazonOrder;
import com.ty.dto.Item;

public class AmazonOrderItem {
	private EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		return entityManagerFactory.createEntityManager();
	}

	public void save(AmazonOrder amazonOrder) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(amazonOrder);
		entityTransaction.commit();
	}

	public AmazonOrder getOrder(int id) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(AmazonOrder.class, id);
	}

	public void addItemsToOrder(int id, List<Item> items) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		AmazonOrder amazonOrder = entityManager.find(AmazonOrder.class, id);
		List<Item> itemList = amazonOrder.getItems();
		itemList.addAll(items);
		entityManager.merge(amazonOrder);
		entityTransaction.commit();
	}

	public void deleteOrder(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		AmazonOrder amazonOrder = entityManager.find(AmazonOrder.class, id);
		if (amazonOrder != null) {
			entityManager.remove(amazonOrder);
		}
		entityTransaction.commit();
	}
}
