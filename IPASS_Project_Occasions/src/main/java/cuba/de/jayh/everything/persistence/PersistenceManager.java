package cuba.de.jayh.everything.persistence;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import cuba.de.jayh.everything.model.Account;
import cuba.de.jayh.everything.model.Car;
import reactor.core.scheduler.Schedulers;
import reactor.netty.http.HttpResources;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


@WebListener
public class PersistenceManager implements ServletContextListener {

    private final static String ENDPOINT = "https://jayhsopslag.blob.core.windows.net/";
    private final static String SASTOKEN = "?sv=2019-10-10&ss=b&srt=sco&sp=rwdlacx&se=2020-06-29T17:22:20Z&st=2020-06-11T09:22:20Z&spr=https&sig=xnsb9SMxBlvBNUjY61C2TOLwB9sTPr%2F7ijTwTKTt68U%3D";
    private final static String CONTAINER = "jayhsopslag";

    private static BlobContainerClient blobContainer = new BlobContainerClientBuilder()
            .endpoint(ENDPOINT)
            .sasToken(SASTOKEN)
            .containerName(CONTAINER)
            .buildClient();


    public static void saveCarsToAzure() throws IOException {
        if (!blobContainer.exists()) {
            blobContainer.create();
        }
        BlobClient blob = blobContainer.getBlobClient("Cars");

        // voor auto's
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(Car.getAllCars());  //

        byte[] bytez = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        blob.upload(bais, bytez.length, true);

        oos.close();
        baos.close();

    }

    public static void loadCarsFromAzure() throws IOException, ClassNotFoundException {
        if (blobContainer.exists()) {
            BlobClient blob = blobContainer.getBlobClient("Cars");

            if (blob.exists()) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blob.download(baos);

                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);

                Object ob = ois.readObject();
                if (ob instanceof List && !((List) ob).isEmpty()) {
                    Car.setAllCars((List) ob);
                    System.out.println(Car.getAllCars().size() + " cars found in loaded list");
                }
//                }else{
//                    Car.createCar("Volkswagen Polo 1.6", "https://media.autoweek.nl/m/pyryc27bzexp_800.jpg", 2000, 2016, 1800, "diesel", "73-MG-HJ", "Volkswagen", "Polo 1.6");
//                    System.out.println("Car created");
//                }
                baos.close();
                ois.close();
            }
        }

    }

    public static void saveAccountsToAzure() throws IOException {
        if (!blobContainer.exists()) {
            blobContainer.create();
        }
        BlobClient blob = blobContainer.getBlobClient("Account");


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(Account.getAllAccounts());

        byte[] bytez = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        blob.upload(bais, bytez.length, true);

        oos.close();
        baos.close();

    }


    public static boolean loadAccountFromAzure() throws IOException, ClassNotFoundException {
        if (blobContainer.exists()) {
            BlobClient blob = blobContainer.getBlobClient("Account");

            if (blob.exists()) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blob.download(baos);

                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);

                Object ob = ois.readObject();
                if (ob instanceof List && !((List) ob).isEmpty()) {
                    Account.setAllAccounts((List) ob);

                    System.out.println(Account.getAllAccounts().size() + " accounts found in loaded list");

                    baos.close();
                    ois.close();
                    return true;
                }

            }
        }
        return false;
    }


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            if(!PersistenceManager.loadAccountFromAzure()){
                System.out.println("Er zijn geen accounts, standaard account wordt geplaats");
              Account a1=   new Account("jayh475", "123");
              a1.setAdmin();
            }
            PersistenceManager.loadCarsFromAzure();



        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("cannot load cars");
//            Car.createCar("Volkswagen Polo 1.6", "https://media.autoweek.nl/m/pyryc27bzexp_800.jpg", 2000, 2016, 1800, "diesel", "73-MG-HJ", "Volkswagen", "Polo 1.6");
            System.out.println("cannot load accounts");
            ioe.printStackTrace();
        }

    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            PersistenceManager.saveCarsToAzure();
            System.out.println("Cars saved! ");
            PersistenceManager.saveAccountsToAzure();
            System.out.println("Accounts saved");

        } catch (IOException ioe) {
            System.out.println("Failed to save Cars");
            System.out.println("failed to save Accounts");

        }

        Schedulers.shutdownNow();
        HttpResources.disposeLoopsAndConnectionsLater(Duration.ZERO, Duration.ZERO).block();

    }
}










