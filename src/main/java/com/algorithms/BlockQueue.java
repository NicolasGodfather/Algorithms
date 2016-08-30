package com.algorithms;

import java.util.LinkedList;

/**
 * Реализация блокирующей очереди.
 * Pessimistic lock - можно зайти в критическую секцию только одной нитью
 * Optimistic lock - есть первоначальное полученное состояние, если сотояние объекта неизменилось,
 * то можно сделать эту запись, если изменилось, то повторно перечитываем данные и проверяем все
 * ли правильно, корректно ли состояние объекта.
 * Монитор это замок.
 *
 */
public class BlockQueue<T> {
	public final LinkedList<T> queue = new LinkedList<T>();

	/**
	 * метод засовывает значения
	 * @param t
     */
	public void push(final T t) {
		synchronized (this.queue) {
			this.queue.add(t);
			this.queue.notifyAll();// сообщает что все кто ждал появления новых событий должен проснуться
		}
	}

	/**
	 * метод получает значения
	 * @return
     */
	public T poll() {
		synchronized (this.queue) {
			//цикл нужен т.к. может быть что данные уже считались и мы пытаемся 2 раз их считать
			while (this.queue.isEmpty()) {
				try {
					this.queue.wait();//становиться на паузу, освобождая монитор
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return this.queue.remove();
		}
	}
}
