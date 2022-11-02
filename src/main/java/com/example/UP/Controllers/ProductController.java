package com.example.UP.Controllers;

import com.example.UP.Models.*;
import com.example.UP.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'WAREHOUSE', 'CASHIER')")
public class ProductController {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ColorRepo colorRepo;
    @Autowired
    ProductTypeRepo productTypeRepo;
    @Autowired
    SupplierRepo supplierRepo;
    @Autowired
    MaterialRepo materialRepo;
    @Autowired
    WarehouseRepo warehouseRepo;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'VIEWER', 'WAREHOUSE', 'CASHIER', 'PURCHASING', 'DELIVERY')")
    @GetMapping("/product")
    public String main(Model model){
        Iterable<Product> listProduct = productRepo.findAll();
        Iterable<Color> listColor = colorRepo.findAll();
        Iterable<ProductType> listProductType = productTypeRepo.findAll();
        Iterable<Supplier> listSupplier = supplierRepo.findAll();
        Iterable<Material> listMaterial = materialRepo.findAll();
        Iterable<Warehouse> listWarehouse = warehouseRepo.findAll();

        model.addAttribute("listProduct", listProduct);
        model.addAttribute("listColor", listColor);
        model.addAttribute("listProductType", listProductType);
        model.addAttribute("listSupplier", listSupplier);
        model.addAttribute("listMaterial", listMaterial);
        model.addAttribute("listWarehouse", listWarehouse);
        return "/Product/index";
    }

    @GetMapping("/product/add")
    public String productAddView(Product product, Model model){
        Iterable<Color> listColor = colorRepo.findAll();
        Iterable<ProductType> listProductType = productTypeRepo.findAll();
        Iterable<Supplier> listSupplier = supplierRepo.findAll();
        Iterable<Material> listMaterial = materialRepo.findAll();
        Iterable<Warehouse> listWarehouse = warehouseRepo.findAll();

        model.addAttribute("listColor", listColor);
        model.addAttribute("listProductType", listProductType);
        model.addAttribute("listSupplier", listSupplier);
        model.addAttribute("listMaterial", listMaterial);
        model.addAttribute("listWarehouse", listWarehouse);
        return "/Product/add";
    }

    @PostMapping("/product/add")
    public String productAdd(@RequestParam String nameProduct,
                             @RequestParam Integer amount,
                             @RequestParam String weight,
                             @RequestParam String price,
                             @RequestParam String date_Of_Production,
                             @RequestParam String color,
                             @RequestParam String productType,
                             @RequestParam String supplier,
                             @RequestParam String material,
                             @RequestParam String warehouse,
                             Model model){
        Color color1 = colorRepo.findByNameColor(color);
        ProductType productTypeRepo1 = productTypeRepo.findByNameType(productType);
        Supplier supplierRepo1 = supplierRepo.findById(Long.valueOf(supplier.split(" ")[0])).orElseThrow();
        Material materialRepo1 = materialRepo.findByNameMaterial(material);
        Warehouse warehouseRepo1 = warehouseRepo.findByAddress(warehouse);

        Product product = new Product(nameProduct, amount, weight, price, date_Of_Production, color1, productTypeRepo1, supplierRepo1, materialRepo1, warehouseRepo1);
        productRepo.save(product);
        return ("redirect:/product");
    }

    @GetMapping("/product/filter-direct")
    public String productFilterDirect(@RequestParam String searchName,
                                       Model model){
        List<Product> product = productRepo.findByNameProduct(searchName);
        model.addAttribute("product", product);
        return "/Product/filter";
    }

    @GetMapping("/product/filter-contains")
    public String productFilterContains(@RequestParam String searchName,
                                         Model model){
        List<Product> product = productRepo.findByNameProductContaining(searchName);
        model.addAttribute("product", product);
        return "/Product/filter";
    }

    @GetMapping("/product/details/{id}")
    public String productDetails(Model model, @PathVariable Long id) {
        Product product = productRepo.findById(id).orElseThrow();
        model.addAttribute("product", product);
        return ("/Product/details");
    }

    @GetMapping("product/del/{id}")
    public String productDelete(@PathVariable Long id) {
        productRepo.deleteById(id);
        return("redirect:/product");
    }

    @GetMapping("/product/edit/{id}")
    public String productEdit(Model model, @PathVariable Long id, Product product_) {
        Product product = productRepo.findById(id).orElseThrow();
        model.addAttribute("product", product);

        Iterable<Color> listColor = colorRepo.findAll();
        Iterable<ProductType> listProductType = productTypeRepo.findAll();
        Iterable<Supplier> listSupplier = supplierRepo.findAll();
        Iterable<Material> listMaterial = materialRepo.findAll();
        Iterable<Warehouse> listWarehouse = warehouseRepo.findAll();

        model.addAttribute("listColor", listColor);
        model.addAttribute("listProductType", listProductType);
        model.addAttribute("listSupplier", listSupplier);
        model.addAttribute("listMaterial", listMaterial);
        model.addAttribute("listWarehouse", listWarehouse);

        return("/Product/edit");
    }

    @PostMapping("/product/edit/{id}")
    public String productEdit(Product product, Model model) {

        productRepo.save(product);
        return("redirect:/product/details/" + product.getId());
    }
}
