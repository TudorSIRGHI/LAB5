import model.client.Client;
import model.client.CompanyClient;
import model.client.StandardClient;
import model.client.VipClient;
import model.market.Cosmetics;
import model.market.EssentialOil;
import model.market.Products;
import model.market.Tea;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cosmetics cosmetics1 = new Cosmetics("Cacao Oil", 60, 72, "Cacao");
        Cosmetics cosmetics2 = new Cosmetics("Cream with Vitamin C", 45, 50, "Nuts");
        Cosmetics cosmetics3 = new Cosmetics("Bath Salt", 42, 50, "Orange");
        Tea tea1 = new Tea("Tea For Cholesterol", 32, 50, "Equisetum arvense, Taraxacum officinale, Urtica dioica");
        Tea tea2 = new Tea("Detox", 57, 100, "Zingiber officinale");
        Tea tea3 = new Tea("Cherry Tea", 37, 50, "Cerasorum stipites");
        EssentialOil essentialOil1 = new EssentialOil("Aroma Difusor", 53, 100, "Lavanda");
        EssentialOil essentialOil2 = new EssentialOil("Aloe Vera", 71, 20, "Aloe Vera");
        EssentialOil essentialOil3 = new EssentialOil("Lemon Oil", 64, 10, "Lemon");
        Client standardClient = new StandardClient(0, false);
        Client companyClient = new CompanyClient(0, false, false);
        Client vipClient = new VipClient(0, false, 0);
        Map<Integer, Client> clients = new HashMap<>();
        clients.put(1, standardClient);
        clients.put(2, companyClient);
        clients.put(3, vipClient);
        List<Integer> probability = new ArrayList<>(List.of(1, 2, 1, 3, 1));
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalSum = 0;
        int monthSum = 0;
        int daySum = 0, clientSum = 0;
        int nrOfClients = 0;
        int nrOfProducts = 0, end = 3, happy = 0, sad = 0;
        int std = 0, com = 0, vip = 0;
        Map<Integer, Integer> integerIntegerMap = new HashMap<>();


        String stop;
        List<Products> products = new ArrayList<>(List.of(cosmetics1, cosmetics2, cosmetics3, tea1, tea2, tea3, essentialOil1, essentialOil3, essentialOil2));
        boolean b = true;
        for (int i = 1; b; i++) {
            daySum = 0;
            System.out.println("Day " + i);
            nrOfClients = random.nextInt(4, 8);
            for (int j = 1; j <= nrOfClients; j++) {
                Client client = clients.get(probability.get(random.nextInt(probability.size())));
                if (client.getClass().equals(StandardClient.class)) {
                    client.setMoney(random.nextInt(100, 120));
                    System.out.println(j + " Standard Client with " + client.getMoney() + " money");
                    std += 1;
                } else if (client.getClass().equals(CompanyClient.class)) {
                    client.setMoney(random.nextInt(120, 150));
                    ((CompanyClient) client).setFirstFreeProduct(true);
                    System.out.println(j + " Company Client with " + client.getMoney() + " money");
                    com += 1;
                } else if (client.getClass().equals(VipClient.class)) {
                    client.setMoney(random.nextInt(150, 200));
                    ((VipClient) client).setDiscount(random.nextInt(5, 10));
                    System.out.println(j + " Vip Client with " + client.getMoney() + " money");
                    vip += 1;
                }
                nrOfProducts = random.nextInt(1, end);
                clientSum = 0;
                System.out.println("   Require: ");
                int a = 0;
                for (int k = 1; k <= nrOfProducts; k++) {
                    Products product = products.get(random.nextInt(products.size()));
                    System.out.println("    " + product.getName() + " with price " + product.getPrice());
                    if (client.getMoney() >= product.getPrice()) {
                        if (client.getClass().equals(CompanyClient.class)) {
                            if ((((CompanyClient) client).isFirstFreeProduct()) && (k == 1)) {
                                client.setHappy(true);
                            } else {
                                clientSum += product.getPrice();
                                client.setMoney(client.getMoney() - product.getPrice());
                                client.setHappy(true);
                            }
                        }
                        if (client.getClass().equals(VipClient.class)) {
                            clientSum += product.getPrice() - (product.getPrice() * (1 / ((VipClient) client).getDiscount()));
                            client.setMoney(client.getMoney() - product.getPrice());
                            client.setHappy(true);
                        }
                        clientSum += product.getPrice();
                        client.setMoney(client.getMoney() - product.getPrice());
                        client.setHappy(true);
                        a += 1;
                    }
                }
                if (a == nrOfProducts) {
                    System.out.println("Client is happy");
                    happy += 1;
                } else {
                    System.out.println("Client is sad");
                    sad += 1;
                }
                daySum += clientSum;
                System.out.println();
            }
            monthSum += daySum;
            System.out.println("+++++++++++++++");
            if (i % 30 == 0) {
                System.out.println("******************************");
                System.out.println(i / 30 + ". Month");
                System.out.println("The month income: " + monthSum);
                System.out.println("The month medium income: " + monthSum / 30);
                int totalNrOfClients = happy + sad;
                System.out.println("Total number of Clients: " + totalNrOfClients);
                float f1 = (float)std/totalNrOfClients*100;
                float f2 = (float)com/totalNrOfClients*100;
                float f3 = (float)vip/totalNrOfClients*100;
                float f4 = (float)happy/totalNrOfClients*100;
                float f5 = (float)sad/totalNrOfClients*100;
                System.out.println("Standard " + std + " with percentage of " + f1 + " %");
                System.out.println("Company: " + com + " with percentage of " + f2 + " %");
                System.out.println("Vip: " + vip + " with percentage of " + f3 + " %");
                List<Integer> integers = new ArrayList<>(List.of(std, com, vip));
                integerIntegerMap.put(std, 1);
                integerIntegerMap.put(com, 2);
                integerIntegerMap.put(vip, 3);
                Integer max = integers.stream().max(Integer::compareTo).orElseThrow();
                Integer min = integers.stream().min(Integer::compareTo).orElseThrow();
                Integer integer1 = integerIntegerMap.get(max);
                Integer integer2 = integerIntegerMap.get(min);
                switch (integer1) {
                    case 1 -> probability.remove(1);
                    case 2 -> probability.remove(2);
                    case 3 -> probability.remove(3);
                }

                switch (integer2) {
                    case 1 -> probability.add(1);
                    case 2 -> probability.add(2);
                    case 3 -> probability.add(3);
                }
                System.out.println("Happy: " + happy + " with percentage of " + f4 + " %");
                System.out.println("Sad: " + sad + " with percentage of " + f5 + " %");
                if (happy > sad) {
                    end += 1;
                } else {
                    end -= 1;
                }
                totalSum += monthSum;
                monthSum = 0;
                happy = 0;
                sad = 0;
                std = 0;
                com = 0;
                vip = 0;
                System.out.println("******************************");

                //Stop & Final Function
                System.out.print("Tap \"0\" to finish: ");
                stop = scanner.next();
                if (stop.equals("0")) {
                    System.out.println("####################################################################");

                    System.out.println("The total income: " + totalSum);
                    System.out.println("The medium income: " + totalSum / (i / 30));
                    System.out.println("####################################################################");
                    b = false;
                }
            }
        }
    }
}