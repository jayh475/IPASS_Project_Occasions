package cuba.de.jayh.everything.persistence;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
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
public class PersistenceManager  implements ServletContextListener {

        private final static String ENDPOINT = "https://jayhsopslag.blob.core.windows.net/";
        private final static String SASTOKEN = "?sv=2019-10-10&ss=b&srt=co&sp=rwdlacx&se=2020-06-20T17:00:46Z&st=2020-06-02T09:00:46Z&spr=https&sig=cjwS7sebjhSBQLuNJcD8qZBkm2%2BoYgTnoq1KWfZ%2BUrc%3D";
        private final static String CONTAINER = "jayhsopslag";

        private static BlobContainerClient blobContainer = new BlobContainerClientBuilder()
                .endpoint(ENDPOINT)
                .sasToken(SASTOKEN)
                .containerName(CONTAINER)
                .buildClient();


        public static void saveCarsToAzure()  throws IOException {
        if (!blobContainer.exists()) {
            blobContainer.create();
        }
        BlobClient blob = blobContainer.getBlobClient("Cars");

        // voor auto's
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(Car.getMy_inventory());  // gaat dit goed ?

        byte[] bytez = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        blob.upload(bais, bytez.length, true);

        oos.close();
        baos.close();

    }
        public static void loadCarsFromAzure() throws IOException,ClassNotFoundException{
            if (blobContainer.exists()) {
                BlobClient blob = blobContainer.getBlobClient("Cars");

            if (blob.exists()) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blob.download(baos);

                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);

                Car loadedCar = (Car) ois.readObject();
                Car.setInventory(loadedCar);

                baos.close();
                ois.close();
            }

        }

        }



    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            PersistenceManager.loadCarsFromAzure();
            System.out.println("Cars loaded");
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("cannot load cars");
            ioe.printStackTrace();

        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try{
            PersistenceManager.saveCarsToAzure();
            System.out.println("Cars saved! ");
        }catch(IOException ioe){
            System.out.println("Failed to save Cars");

        }
        Schedulers.shutdownNow();
        HttpResources.disposeLoopsAndConnectionsLater(Duration.ZERO, Duration.ZERO).block();
    }
}










