package com.mubaiwa.trust.umkhathi.feature.weather.view

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mubaiwa.trust.umkhathi.common.AppConstants
import com.mubaiwa.trust.umkhathi.databinding.FragmentHomeBinding
import com.mubaiwa.trust.umkhathi.feature.weather.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkLocationPermission()
    }

    /** Permission Methods */

    private fun checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestLocationPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
        }

        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            requestLocationPermissions(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
    }

    private fun requestLocationPermissions(permission: String) {
        if (shouldShowRequestPermissionRationale(permission)) {
            AlertDialog.Builder(requireContext())
                    .setTitle("Permission Required")
                    .setMessage("Location permission will be required in the registration process")
                    .setPositiveButton("OK") { _, _ ->
                        requestPermissions(arrayOf(permission), AppConstants.Permission.LOCATION_REQUEST_CODE)
                    }
                    .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
                    .create().show()
        } else {
            requestPermissions(arrayOf(permission), AppConstants.Permission.LOCATION_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            AppConstants.Permission.LOCATION_REQUEST_CODE -> {
                val granted = grantResults.all { perm -> perm == PackageManager.PERMISSION_GRANTED }
                if (granted) {
                    viewModel.requestDeviceLocation()
                } else {
                    AlertDialog.Builder(requireContext())
                            .setTitle("Enable Permissions")
                            .setMessage("Enable Location permissions from settings")
                            .setPositiveButton("OK") { _, _ -> startApplicationSettings() }
                            .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
                            .create().show()
                }
            }
        }
    }

    private fun startApplicationSettings() {
        Intent().also {
            it.apply {
                action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                data = Uri.fromParts("package", requireActivity().packageName, null)
            }
            requireContext().startActivity(it)
        }
    }
}