package com.shreeram.demosb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemosbApplicationTests {
	@Test
	void divideByZero_infinity_fractional_test() {
		double x = 5.66;
		String actual = String.valueOf(x/0);
		assertThat(actual).isEqualTo("Infinity");
	}

	@Test
	void divideByZero_infinity_integer_test() {
		assertThatThrownBy(()-> {
			int x=5;
			int y=x/0;
		} , "testing explosive code")
		.isInstanceOf(ArithmeticException.class)
		.hasMessage("/ by zero");
	}
	@Test
	void contextLoads() {
		ReentrantLock rlock = new ReentrantLock();
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		ReentrantReadWriteLock.ReadLock read = lock.readLock();
		ReentrantReadWriteLock.WriteLock write = lock.writeLock();
		Condition condition = rlock.newCondition();
		ExecutorService es = Executors.newSingleThreadExecutor();
		try {
			Future<?> f = es.submit(() -> {
				rlock.lock();
				for (int i = 0; i < 100; i++)
					System.out.println(i);
				rlock.unlock();
			}, "hello there");
			System.out.println(f.get());
			f = es.submit(() -> {
				return 0;
			});
			es.shutdown();
			System.out.println(f.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
