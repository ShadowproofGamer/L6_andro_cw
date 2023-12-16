package com.example.l6_andro_cw

import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import com.example.l6_andro_cw.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    private lateinit var _binding: FragmentStartBinding
    private var basePhotoUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStartBinding.inflate(inflater, container, false)


        val dir2 = Environment.getExternalStorageDirectory()
        val dir3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val dir4 = requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        _binding . tv1path . text = basePhotoUri . scheme +":/" + MediaStore.Images.Media.EXTERNAL_CONTENT_URI.path
        _binding . tv2path . text = dir2 . absolutePath
        _binding.tv3path.text = dir3.absolutePath
        _binding . tv4path . text = dir4 ?. absolutePath ?: "nothing"
        dir4?.let {
            val theuri = FileProvider.getUriForFile(requireContext(),
                "${BuildConfig.APPLICATION_ID}.provider", it)
            _binding . tv5path . text = theuri . scheme +":/" + theuri.path
        }



        return _binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StartFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}