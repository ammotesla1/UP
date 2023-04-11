package com.example.UP.Services;

import com.example.UP.Models.Product;
import com.example.UP.Models.Supplier;
import com.example.UP.Models.Warehouse;
import com.example.UP.Repositories.ProductRepo;
import com.example.UP.Repositories.SupplierRepo;
import com.example.UP.Repositories.WarehouseRepo;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private WarehouseRepo warehouseRepo;


    public static String UPLOAD_DIRECTORY = "C:\\Users\\danil\\Desktop\\FurnitureStore\\src\\main\\resources\\static\\uploads\\";

    public void saveProductToDB(MultipartFile imageProduct, String nameProduct, Integer amount, Double weigth, Double price,String dateOfProduction){

        Product product = new Product();
        try {
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, imageProduct.getOriginalFilename());
            fileNames.append(imageProduct.getOriginalFilename());
            Files.write(fileNameAndPath, imageProduct.getBytes());
            product.setImageProduct("uploads\\" + imageProduct.getOriginalFilename());
            product.setNameProduct(nameProduct);
            product.setAmount(amount);
            product.setPrice(price);
            product.setWeight(weigth);
            product.setDateOfProduction(dateOfProduction);
            product.getSupplier();
            product.getWarehouse();
            productRepo.save(product);
        } catch (IOException e){
            e.printStackTrace();
        }

//        Product product = new Product();
//        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
//        if(fileName.contains("..")){
//            System.out.println("not a a valid file");
//        }
//        try{
//            product.setImageProduct(Base64.getEncoder().encodeToString(image.getBytes()));
//            System.out.println(fileName);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
