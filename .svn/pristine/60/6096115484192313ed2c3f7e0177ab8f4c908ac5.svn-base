package com.linkwin.web.controller.pointsCashing;

import com.linkwin.basedata.domain.Product;
import com.linkwin.basedata.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("pointsCashing")
@Controller
public class pointsCashingController {


    private String prefix = "pointsCashing/pointsCashing";

    @Autowired
    private IProductService productService;




    @GetMapping("product")
    public String product(String phoneNumber, ModelMap mmap)
    {
        List<Product> product =productService.selectCashingProductList(new Product());

            mmap.put("product",product);
            return prefix + "/fwQuery";
//        mmap.put("code",code);

    }







}
