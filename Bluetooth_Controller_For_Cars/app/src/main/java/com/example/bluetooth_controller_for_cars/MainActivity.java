package com.example.bluetooth_controller_for_cars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    /*
                 Permissions:
                <uses-permission android:name="android.permission.BLUETOOTH" />
                <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
     */

    public Button button;
    public EditText editText;
    public BluetoothAdapter btAdapter;
    public BluetoothDevice btDevice;
    public BluetoothSocket btSocket;

    public static final String SERVICE_ID = "00001101-0000-1000-8000-00805f9b34fb"; //SPP UUID
    public static final String SERVICE_ADDRESS = "98:D3:31:FB:82:85"; // HC-05 BT ADDRESS


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btAdapter = BluetoothAdapter.getDefaultAdapter();
        btDevice = btAdapter.getRemoteDevice(SERVICE_ADDRESS);

        if(btAdapter == null)
        {
            Toast.makeText(getApplicationContext(), "Bluetooth not available", Toast.LENGTH_LONG).show();
        }
        else
        {
            if(!btAdapter.isEnabled())
            {
                Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableIntent, 3);
            }
            else
            {
                ConnectThread connectThread = new ConnectThread(btDevice);
                connectThread.start();
            }
        }


    }

    @Override
    public void onClick(View v)
    {
        if(btSocket != null)
        {
            switch (v.getId())
            {
                case R.id.Up:

                    try
                    {
                        OutputStream out = btSocket.getOutputStream();
                        out.write(("U" + "\r\n").getBytes());
                    }
                    catch(IOException e)
                    {

                    }

                 break;

                 case R.id.Down:

                     try
                     {
                         OutputStream out = btSocket.getOutputStream();
                         out.write(("D" + "\r\n").getBytes());
                     }
                     catch(IOException e)
                     {

                     }
                 break;

                case R.id.Left:

                    try
                    {
                        OutputStream out = btSocket.getOutputStream();
                        out.write(("L" + "\r\n").getBytes());
                    }
                    catch(IOException e)
                    {

                    }
                break;

                case R.id.Right:

                    try
                    {
                        OutputStream out = btSocket.getOutputStream();
                        out.write(("R" + "\r\n").getBytes());
                    }
                    catch(IOException e)
                    {

                    }
                 break;

            }


        }

    }


    private class ConnectThread extends Thread
    {
        private final BluetoothSocket thisSocket;
        private final BluetoothDevice thisDevice;

        public ConnectThread(BluetoothDevice device)
        {
            BluetoothSocket tmp = null;
            thisDevice = device;

            try
            {
                tmp = thisDevice.createRfcommSocketToServiceRecord(UUID.fromString(SERVICE_ID));
            }
            catch (IOException e)
            {
                Log.d("TESTING", "Can't connect to service");
            }
            thisSocket = tmp;
        }

        public void run()
        {
            // Cancel discovery because it otherwise slows down the connection.
            btAdapter.cancelDiscovery();

            try
            {
                thisSocket.connect();
                Log.d("TESTING", "Connected to shit");
            }
            catch (IOException connectException)
            {
                try
                {
                    thisSocket.close();
                }
                catch (IOException closeException)
                {
                    Log.d("TESTING", "Can't close socket");
                }
                return;
            }

            btSocket = thisSocket;

        }
        public void cancel()
        {
            try
            {
                thisSocket.close();
            }
            catch (IOException e)
            {
                Log.d("TESTING", "Can't close socket");
            }
        }
    }

}