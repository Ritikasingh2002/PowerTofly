package com.hackygirls.kavachh.fragments

import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.volley.Request

import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.maps.android.PolyUtil
import com.hackygirls.kavachh.R
import org.json.JSONObject

class MapFragment : Fragment(), OnMapReadyCallback {


    private lateinit var mMap:GoogleMap
    private lateinit var lastLocation: Location
    lateinit var mapFragment: SupportMapFragment
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    companion object{
        private const val LOCATION_REQUEST_CODE=1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapFragment = childFragmentManager.findFragmentById(R.id.maps) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
//        val polyline1 = googleMap.addPolyline(PolylineOptions()
//            .clickable(true)
//            .add(
//                LatLng(-35.016, 143.321),
//                LatLng(-34.747, 145.592),
//                LatLng(-34.364, 147.891),
//                LatLng(-33.501, 150.217),
//                LatLng(-32.306, 149.248),
//                LatLng(-32.491, 147.309)))

//        polyline1.tag = "A"
//        // Position the map's camera near Alice Springs in the center of Australia,
//        // and set the zoom factor so most of Australia shows on the screen.
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-23.684, 133.903), 4f))
//
        // Set listeners for click events.
//        googleMap.setOnPolylineClickListener(this)
//        googleMap.setOnPolygonClickListener(this)

        val latLngOrigin = LatLng(28.732276839613316, 77.47636056669033)
        val latLngDestination = LatLng(28.732276839613316, 77.47636056669033)
        this.mMap.addMarker(MarkerOptions().position(latLngOrigin).title("Tyagi Wine Shop"))
        this.mMap.addMarker(MarkerOptions().position(latLngDestination).title("Tyagi Wine Shop"))
        this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngOrigin, 14.5f))
        val path: MutableList<List<LatLng>> = ArrayList()
        val urlDirections =
            "https://www.google.com/maps/embed/v1/directions?key=AIzaSyDz2euCmqSduREe7n-LIMb6YxX87pPQkMY&amp;origin=28.732276839613316,77.47636056669033&amp;destination=28.732276839613316, 77.47636056669033&amp;avoid=tolls%7Chighways"
       // "https://maps.googleapis.com/maps/api/directions/json?origin=28.732276839613316,77.47636056669033&destination=28.756591561664152,77.49777596163247key=<AIzaSyDz2euCmqSduREe7n-LIMb6YxX87pPQkMY>"
        if (path.size > 0) {
            val directionsRequest = object : StringRequest(
                Request.Method.GET,
                urlDirections,
                Response.Listener<String> { response ->
                    val jsonResponse = JSONObject(response)
                    // Get routes

                    val routes = jsonResponse.getJSONArray("routes")
                    val legs = routes.getJSONObject(0).getJSONArray("legs")
                    val steps = legs.getJSONObject(0).getJSONArray("steps")
                    for (i in 0 until steps.length()) {
                        val points =
                            steps.getJSONObject(i).getJSONObject("polyline").getString("points")
                        path.add(PolyUtil.decode(points))
                        this.mMap.addPolyline(PolylineOptions().addAll(path[i]).width(5F).color(Color.BLUE).geodesic(true))
                    }
                    for (i in 0 until path.size) {
                        this.mMap.addPolyline(PolylineOptions().addAll(path[i]).width(5F).color(Color.BLUE).geodesic(true)
                        )
                    }
                 //this.mMap.addPolyline(PolylineOptions().addAll(path.size).width(5F).color(Color.BLUE).geodesic(true))


                },
                Response.ErrorListener { _ ->
                }) {}
            val requestQueue = Volley.newRequestQueue(requireContext())
            requestQueue.add(directionsRequest)
        }
    }
//
//    private val PATTERN_GAP_LENGTH_PX = 20
//    private val DOT: PatternItem = Dot()
//    private val GAP: PatternItem = Gap(PATTERN_GAP_LENGTH_PX.toFloat())
//    // Create a stroke pattern of a gap followed by a dot.
//    private val PATTERN_POLYLINE_DOTTED = listOf(GAP, DOT)
//    override fun onPolylineClick(polyline: Polyline) {
//        // Flip from solid stroke to dotted stroke pattern.
//        if (polyline.pattern == null || !polyline.pattern!!.contains(DOT)) {
//            polyline.pattern = PATTERN_POLYLINE_DOTTED
//        } else {
//            // The default pattern is a solid stroke.
//            polyline.pattern = null
//        }
////        Toast.makeText(this, "Route type " + polyline.tag.toString(),
////            Toast.LENGTH_SHORT).show()
//    }
//
//
//    private val COLOR_BLACK_ARGB = -0x1000000
//    private val POLYLINE_STROKE_WIDTH_PX = 12
//
//    /**
//     * Styles the polyline, based on type.
//     * @param polyline The polyline object that needs styling.
//     */
//    private fun stylePolyline(polyline: Polyline) {
//        // Get the data object stored with the polyline.
//        val type = polyline.tag?.toString() ?: ""
//        when (type) {
//            "A" -> {
//                // Use a custom bitmap as the cap at the start of the line.
//                polyline.startCap = CustomCap(
//                    BitmapDescriptorFactory.fromResource(R.drawable.ic_arrow), 10f)
//            }
//            "B" -> {
//                // Use a round cap at the start of the line.
//                polyline.startCap = RoundCap()
//            }
//        }
//        polyline.endCap = RoundCap()
//        polyline.width = POLYLINE_STROKE_WIDTH_PX.toFloat()
//        polyline.color = COLOR_BLACK_ARGB
//        polyline.jointType = JointType.ROUND
//    }
//
//
//    private val COLOR_WHITE_ARGB = -0x1
//    private val COLOR_DARK_GREEN_ARGB = -0xc771c4
//    private val COLOR_LIGHT_GREEN_ARGB = -0x7e387c
//    private val COLOR_DARK_ORANGE_ARGB = -0xa80e9
//    private val COLOR_LIGHT_ORANGE_ARGB = -0x657db
//    private val POLYGON_STROKE_WIDTH_PX = 8
//    private val PATTERN_DASH_LENGTH_PX = 20
//
//    private val DASH: PatternItem = Dash(PATTERN_DASH_LENGTH_PX.toFloat())
//
//    // Create a stroke pattern of a gap followed by a dash.
//    private val PATTERN_POLYGON_ALPHA = listOf(GAP, DASH)
//
//    // Create a stroke pattern of a dot followed by a gap, a dash, and another gap.
//    private val PATTERN_POLYGON_BETA = listOf(DOT, GAP, DASH, GAP)
//
//    /**
//     * Styles the polygon, based on type.
//     * @param polygon The polygon object that needs styling.
//     */
//    private fun stylePolygon(polygon: Polygon) {
//        // Get the data object stored with the polygon.
//        val type = polygon.tag?.toString() ?: ""
//        var pattern: List<PatternItem>? = null
//        var strokeColor = COLOR_BLACK_ARGB
//        var fillColor = COLOR_WHITE_ARGB
//        when (type) {
//            "alpha" -> {
//                // Apply a stroke pattern to render a dashed line, and define colors.
//                pattern = PATTERN_POLYGON_ALPHA
//                strokeColor = COLOR_DARK_GREEN_ARGB
//                fillColor = COLOR_LIGHT_GREEN_ARGB
//            }
//            "beta" -> {
//                // Apply a stroke pattern to render a line of dots and dashes, and define colors.
//                pattern = PATTERN_POLYGON_BETA
//                strokeColor = COLOR_DARK_ORANGE_ARGB
//                fillColor = COLOR_LIGHT_ORANGE_ARGB
//            }
//        }
//        polygon.strokePattern = pattern
//        polygon.strokeWidth = POLYGON_STROKE_WIDTH_PX.toFloat()
//        polygon.strokeColor = strokeColor
//        polygon.fillColor = fillColor
//    }
//
//    override fun onPolygonClick(p0: Polygon) {
//        TODO("Not yet implemented")
//    }



}