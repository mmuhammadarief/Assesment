package org.d3if4045.bmi


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_main.*
import org.d3if4045.bmi.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,R.layout.fragment_main,container,false)

        var berat = binding.etBeratBadan.text.toString().toInt()
        var tinggi = binding.etTinggiBadan.text.toString().toDouble()/100
        var hasil = berat/Math.pow(tinggi,2.00)
        binding.btHitung.setOnClickListener {
            if (rb_Pria.isChecked){
                if (hasil < 18.50) {
                    binding.tvNilaiBmi.text = "$hasil"
                    binding.tvStatus.text = "KURUS"
                } else if (hasil < 18.50 || hasil > 24.99) {
                    binding.tvNilaiBmi.text = "$hasil"
                    binding.tvStatus.text = "IDEAL"
                } else if (hasil >= 25.00) {
                    binding.tvNilaiBmi.text = "$hasil"
                    binding.tvStatus.text = "GEMUK"
                }
        }else if (rb_Wanita.isChecked){
                if (hasil < 20.50) {
                    binding.tvNilaiBmi.text = "$hasil"
                    binding.tvStatus.text = "KURUS"
                } else if (hasil < 20.50 || hasil > 26.99) {
                    binding.tvNilaiBmi.text = "$hasil"
                    binding.tvStatus.text = "IDEAL"
                } else if (hasil >= 27.00) {
                    binding.tvNilaiBmi.text = "$hasil"
                    binding.tvStatus.text = "GEMUK"
                }
            }
        }
        return binding.root
    }


}
