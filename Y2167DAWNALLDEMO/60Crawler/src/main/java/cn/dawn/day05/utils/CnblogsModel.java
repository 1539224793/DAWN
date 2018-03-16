package cn.dawn.day05.utils;

import cn.dawn.day05.entity.Cnblog;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Dawn on 2018/3/9.
 */
public class CnblogsModel
{
    public static String SendPostCnBlog(String url, JSONObject jo) {
        CloseableHttpClient client = HttpClients.createDefault();
        String result = "查询失败";
        try {
            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(jo.toString(), "utf-8");// 解决中文乱码问题
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            HttpResponse resp = client.execute(httpPost);

            if (resp.getStatusLine().getStatusCode() == 200) {
                HttpEntity he = resp.getEntity();
                result = EntityUtils.toString(he, "UTF-8");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    //cnblog -post请求
    public static JSONObject jsonMaker(int i){
        JSONObject jo = new JSONObject();
        jo.put("CategoryType", "TopDiggs");
        jo.put("ParentCategoryId", 0);
        jo.put("CategoryId", 0);
        jo.put("PageIndex", i);
        jo.put("TotalPostCount", 0);
        jo.put("ItemListActionName", "PostList");

        return jo;

    }


    public static ArrayList<Cnblog> GetContens(String content) {
        ArrayList<Cnblog> results = new ArrayList<Cnblog>();
        Document doc = Jsoup.parse(content);
        Elements items = doc.getElementsByClass("post_item_body");
        for (Element item : items) {
            Element h2TagEle = item.getElementsByTag("h3").first(); // 推荐内容标题元素
            Element aTagEl = h2TagEle.getElementsByTag("a").first(); // 推荐内容的Url超链接元素
            String href = aTagEl.attr("href");
            System.out.println(aTagEl.text() + "  " + href);
            Cnblog cnblog=new Cnblog();
            cnblog.setBgtitle(aTagEl.text());
            cnblog.setBgpath(href);
            results.add(cnblog);
        }
        return results;
    }

    public static void main(String[] args) {
        GetContens(SendPostCnBlog("http://www.cnblogs.com/mvc/AggSite/PostList.aspx",jsonMaker(1)));
    }
}
