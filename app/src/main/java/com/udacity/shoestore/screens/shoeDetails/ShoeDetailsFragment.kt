package com.udacity.shoestore.screens.shoeDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeViewModel


class ShoeDetailsFragment : Fragment(R.layout.fragment_shoe_details) {

    private var _binding: FragmentShoeDetailsBinding? = null
    private val binding get() = _binding!!

    //    private val shoeViewModel: ShoeViewModel by viewModels()
    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoeDetailsBinding.inflate(inflater, container, false)

        binding.shoe = Shoe()
        binding.saveBtn.setOnClickListener {
//            val newShow = Shoe(
//                name = binding.shoeNameEditText.text.toString(),
//                company = binding.companyNameEditText.text.toString(),
//                description = binding.descriptionEditText.text.toString(),
//                size = binding.shoeSizeEditText.text.toString().toDouble(),
//            )

//            Timber.i("name is ${(binding.shoe as Shoe)}")
            shoeViewModel.addShoe(binding.shoe as Shoe)

            view?.findNavController()?.navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}