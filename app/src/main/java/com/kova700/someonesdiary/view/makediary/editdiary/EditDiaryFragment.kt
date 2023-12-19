package com.kova700.someonesdiary.view.makediary.editdiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kova700.someonesdiary.R
import com.kova700.someonesdiary.databinding.FragmentEditDiaryBinding
import com.kova700.someonesdiary.view.makediary.MakeDiaryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditDiaryFragment : Fragment() {
    private var _binding: FragmentEditDiaryBinding? = null
    private val binding get() = _binding!!

    private val makeDiaryViewModel by activityViewModels<MakeDiaryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditDiaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImageViewClickListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setImageViewClickListener(){
        binding.ivCoverImgEditDiary.setOnClickListener {
            findNavController().navigate(R.id.action_edit_diary_fragment_to_image_search_fragment)
        }
    }
}