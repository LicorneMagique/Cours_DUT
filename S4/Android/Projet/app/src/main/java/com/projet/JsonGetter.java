package com.projet;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class JsonGetter extends AsyncTask<Object,Void, String> {


    @Override
    protected String doInBackground(Object... objects)
    {
        String urlText = (String) objects[0];
        String content = "";
        try
        {
            URL url = new URL(urlText);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            if(urlConnection.getResponseCode() ==  HttpURLConnection.HTTP_OK)
            {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream())
                );
                StringBuilder str = new StringBuilder();
                String ligne;
                while((ligne = in.readLine()) != null) {
                    str.append(ligne);
                }
                //content = in.readLine();
                content = str.toString();
                in.close();
            }
            urlConnection.disconnect();
        }
        catch (Exception e)
        {
            Log.d("Async","erreur url :  ");
            content = "Une erreur est survenue lors de la connexion";
        }
        ArrayList<Station> stations = new ArrayList<>();
        try
        {

            JSONObject jsonObject = new JSONObject(content);
            JSONArray jsonMainNode = jsonObject.optJSONArray("pdv");
            for(int i=0; i < jsonMainNode.length(); i++)
            {

                JSONObject stationNode = jsonMainNode.getJSONObject(i);
                JSONArray prixNode = stationNode.optJSONArray("prix");


                if(prixNode != null)
                {
                    Station station = new Station(stationNode.getString("adresse"));
                    stations.add(station);
                    Log.d("carb",""+prixNode);
                    
                    for(int j =0;j<prixNode.length();j++)
                    {
                        JSONObject carburant = prixNode.getJSONObject(i).getJSONObject("@attributes");


                        Log.d("carb",""+carburant);
                        String nom = carburant.getString("nom");
                        Log.d("carb",nom );
                        double prix =  carburant.getDouble("valeur");
                        Log.d("carb", ""+prix );

                    }
                }


            }
        }
        catch (Exception e)
        {
            Log.d("JSON","erreur JSON  : " + e);
        }



        return content;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d("Json",s);
    }

}
