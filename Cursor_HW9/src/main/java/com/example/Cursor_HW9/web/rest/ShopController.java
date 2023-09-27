package com.example.Cursor_HW9.web.rest;

import com.example.Cursor_HW9.entity.ShopDTO;
import com.example.Cursor_HW9.entity.Shop;
import com.example.Cursor_HW9.service.ShopService;
import com.example.Cursor_HW9.service.exception.ShopException;
import com.example.Cursor_HW9.service.impl.ShopServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/shops/*")
public class ShopController extends HttpServlet {

    private ShopService shopService;

    @Override
    public void init() throws ServletException {
        super.init();
        shopService = new ShopServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            if (pathInfo == null || pathInfo.equals("/")) {
                List<ShopDTO> shopDTOs = shopService.getAllShops().stream()
                        .map(ShopDTO::new)
                        .collect(Collectors.toList());
                response.setContentType("application/json");
                objectMapper.writeValue(response.getWriter(), shopDTOs);
            } else {
                String[] pathParts = pathInfo.split("/");
                if (pathParts.length == 2) {
                    Long id = Long.parseLong(pathParts[1]);
                    Shop shop = shopService.getShopById(id);
                    if (shop != null) {
                        response.setContentType("application/json");
                        objectMapper.writeValue(response.getWriter(), new ShopDTO(shop));
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    }
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                }
            }
        } catch (ShopException exception) {
            response.setContentType("text/plain; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            objectMapper.writeValue(response.getWriter(), exception.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Shop shop = objectMapper.readValue(request.getReader(), Shop.class);
            Shop createdShop = shopService.createShop(shop);
            if (createdShop != null) {
                response.setStatus(HttpServletResponse.SC_CREATED);
                response.setContentType("application/json");
                objectMapper.writeValue(response.getWriter(), new ShopDTO(createdShop));
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } catch (Exception ex) {
            response.setContentType("text/plain; charset=utf-8");
            objectMapper.writeValue(response.getWriter(), "Під час додавання об'єкта виникла помилка");
        }
    }

}
