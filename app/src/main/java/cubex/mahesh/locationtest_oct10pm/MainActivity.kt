package cubex.mahesh.locationtest_oct10pm

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      var lManager:LocationManager =   getSystemService(
              Context.LOCATION_SERVICE) as LocationManager

     lManager.getLastKnownLocation(
             LocationManager.NETWORK_PROVIDER)
// String provider, long minTime, float minDistance, LocationListener listener
        lManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                1000.toLong(),1.toFloat(),
                object : LocationListener {
                    override fun onLocationChanged(p0: Location?) {

                        var lati = p0!!.latitude
                        var longi = p0!!.longitude

                        textView.text = lati.toString()
                        textView2.text = longi.toString()

                  //      lManager.removeUpdates(this)

                    }

                    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onProviderEnabled(p0: String?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onProviderDisabled(p0: String?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }


                })

    }
}
