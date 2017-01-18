package org.moneyproj.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.moneyproj.dao.CoinDao;
import org.moneyproj.entities.BaseCodeHolder;
import org.moneyproj.entities.Coin;
import org.moneyproj.rest.interceptors.Compress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class CoinResource {

    @Autowired
    private CoinDao coinDao;

    public final void setCoinDao(final CoinDao coinDao) {
        this.coinDao = coinDao;
    }

    public final List<Coin> getAllCoins() {
        Date date = new GregorianCalendar(TimeZone.getDefault()).getTime();

        // List<Coin> coins = coinDao.getCoinsAll();
        List<Coin> coins = coinDao.getCoins(date, BaseCodeHolder.getValue());

        if (coins == null) {
            throw new RuntimeException("Can't load all coins");
        }
        return coins;
    }

    public final Coin getCoinById(final Integer id) {
        Coin coin = coinDao.read(id);

        if (coin == null) {
            throw new RuntimeException("can't find coin with id = " + id);
        }

        return coin;
    }

    @GET
    @Path("/coins")
    @Compress
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,
        "text/csv" })
    // @Produces(MediaType.TEXT_XML)
    public final List<Coin> getAllCoinsXML() {
        return getAllCoins();
    }

    @GET
    @Path("/coins/{id}")
    @Compress
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public final Coin getCoinByIdXML(@PathParam("id") final Integer id) {
        return getCoinById(id);
    }

    @GET
    @Path("/coins/{id}")
    @Compress
    @Produces("text/csv")
    public final List<Coin> getCoinByIdCSV(@PathParam("id") final Integer id) {
        List<Coin> list = new ArrayList<Coin>();
        list.add(getCoinById(id));
        return list;
    }

    @DELETE
    @Path("/coins/{id}")
    public final void deleteCoin(@PathParam("id") final Integer id) {
        coinDao.delete(id);
    }

    @PUT
    @Path("/coins")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public final Response updateCoin(final Coin coin) {
        Response res;
        Coin coinExist = new Coin();
        if (coin.getId() != null) {
            coinExist = coinDao.read(coin.getId());
        }
        if ((coin.getId() == null) || (coinExist.getId() == null)) {
            coinDao.create(coin);
            res = Response.status(Response.Status.CREATED)
                   .entity("<b>Server receive:</b> " + coin.toString()).build();
        } else {
            coinDao.update(coin);
            res = Response.noContent().build();
        }
        return res;
    }

    @POST
    @Path("/coins")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public final Response saveNewCoin(final Coin coin) {
        coinDao.create(coin);
        return Response.status(Response.Status.CREATED)
                .entity("<b>Server receive:</b> " + coin.toString()).build();
    }
}
