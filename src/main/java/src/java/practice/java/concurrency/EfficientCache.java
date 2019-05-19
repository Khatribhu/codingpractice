package src.java.practice.java.concurrency;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class EfficientCache {

}

interface Computable<A, V> {
	V compute(A arg) throws InterruptedException;
}

class ExpensiveFunction implements Computable<String, BigInteger> {

	@Override
	public BigInteger compute(String arg) throws InterruptedException {
		return new BigInteger(arg);
	}
}

class Memorizer1<A, V> implements Computable<A, V> {

	private final Map<A, V> cache = new HashMap<>();
	private final Computable<A, V> c;

	public Memorizer1(Computable<A, V> c) {
		this.c = c;
	}

	public synchronized V compute(A arg) throws InterruptedException {
		V result = cache.get(arg);
		if (result == null) {
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}
}

class Memoizer2<A, V> implements Computable<A, V> {
	private final Map<A, V> cache = new ConcurrentHashMap<>();
	private final Computable<A, V> c;

	public Memoizer2(Computable<A, V> c) {
		this.c = c;
	}

	public V compute(A arg) throws InterruptedException {
		V result = cache.get(arg);
		if (result == null) {
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}
}

class Memoizer3<A, V> implements Computable<A, V> {
	private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
	private final Computable<A, V> c;

	public Memoizer3(Computable c) {
		this.c = c;
	}

	public V compuate(final A arg) throws InterruptedException {
		Future<V> f = cache.get(arg);
		if (f == null) {
			Callable<V> eval = new Callable<V>() {
				public V call() throws InterruptedException {
					return c.compute(arg);
				}
			};
			FutureTask<V> ft = new FutureTask<>(eval);
			f = ft;
			cache.put(arg, ft);
			ft.run(); // call to c.compute happen here.
		}
		try {
			return f.get();
		} catch (ExecutionException e) {
			throw new InterruptedException(e.getMessage());
			// throw launderThrowable(e.getCause());
		}
	}

	@Override
	public V compute(A arg) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}
}

class Memoizer<A, V> implements Computable<A, V> {
	private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<>();
	private final Computable<A, V> c;

	public Memoizer(Computable<A, V> c) {
		this.c = c;
	}

	public V compute(final A arg) throws InterruptedException {
		while (true) {
			Future<V> f = cache.get(arg);
			if (f == null) {
				Callable<V> eval = new Callable<V>() {
					public V call() throws InterruptedException {
						return c.compute(arg);
					}
				};

				FutureTask<V> ft = new FutureTask<>(eval);
				f = cache.putIfAbsent(arg, ft);
				if (f == null) {
					f = ft;
					ft.run();
				}
			}
			try {
				return f.get();
			} catch (CancellationException e) {
				cache.remove(arg, f);
			} catch (ExecutionException e) {
				throw new InterruptedException(e.getMessage());
			}
		}
	}

}