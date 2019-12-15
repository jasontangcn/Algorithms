package com.fruits.algo.stackqueue;

public class QueueQuestion {
	private static class CustomerService {
		private int arriveTime;
		private int serviceTime;

		public CustomerService(int arriveTime, int serviceTime) {
			this.arriveTime = arriveTime;
			this.serviceTime = serviceTime;
		}
	}

	private static CustomerService[] customers = new CustomerService[] { new CustomerService(100, 30), new CustomerService(110, 10), new CustomerService(110, 40), new CustomerService(200, 50) };

	public static void main(String[] args) {
		Queue queue = new Queue(200);
		int index = 0;
		int count = customers.length;
		int clock = 0;
		int servantIdleTime = 0;
		int customerWaitingTime = 0;
		int customersCount = 0;

		do {
			if (!queue.isEmpty()) {
				CustomerService cs = (CustomerService) queue.dequeue();
				customerWaitingTime += (clock - cs.arriveTime);
				customersCount++;
				clock += (cs.serviceTime);
			} else if (queue.isEmpty() && (index < count)) {
				CustomerService customer = customers[index++];
				servantIdleTime += (customer.arriveTime - clock);
				clock = (customer.arriveTime + customer.serviceTime);
				customersCount++;
			}

			for (int i = index; i < count; i++) {
				CustomerService c = customers[i];
				if (c.arriveTime < clock) {
					queue.enqueue(c);
					index++;
				}
			}
		} while (!queue.isEmpty() || index < count);

		System.out.println("servantIdleTime: " + servantIdleTime);
		System.out.println("customerWaitingTime: " + customerWaitingTime);
		System.out.println("customersCount: " + customersCount);
	}
}
