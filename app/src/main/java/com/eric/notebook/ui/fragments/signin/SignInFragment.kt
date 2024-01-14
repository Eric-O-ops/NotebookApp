package com.eric.notebook.ui.fragments.signin

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eric.notebook.R
import com.eric.notebook.base.BaseFragment
import com.eric.notebook.databinding.FragmentSignInBinding

class SignInFragment :
    BaseFragment<FragmentSignInBinding, SignInViewModel>(R.layout.fragment_sign_in) {

    override val binding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels()
   /* private var verificationId = ""
    private lateinit var options: PhoneAuthOptions*/

    override fun initialize() {

      /*  binding.materialButton.setOnClickListener {
            if (binding.materialButton.text == "Получить код") {
                options = PhoneAuthOptions
                    .newBuilder(Firebase.auth)
                    .setPhoneNumber("+${binding.editText.text}")
                    .setTimeout(30L, TimeUnit.SECONDS)
                    .setActivity(requireActivity())
                    .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                        override fun onCodeSent(
                            verificationId: String,
                            forceResendingToken: PhoneAuthProvider.ForceResendingToken,
                        ) {
                            this@SignInFragment.verificationId = verificationId
                            // The corresponding whitelisted code above should be used to complete sign-in.

                        }

                        override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                            // Sign in with the credential
                            // ...
                        }

                        override fun onVerificationFailed(e: FirebaseException) {
                            Toast.makeText(
                                requireContext(),
                                "Что-то пошло не так...",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }).build()
                PhoneAuthProvider.verifyPhoneNumber(options)
                binding.materialButton.text = "Подтвердить код"
            } else {
                val firebaseAuth = Firebase.auth
                val firebaseAuthSettings = firebaseAuth.firebaseAuthSettings

                // Configure faking the auto-retrieval with the whitelisted numbers.
                firebaseAuthSettings.setAutoRetrievedSmsCodeForPhoneNumber(
                    "+${binding.editText.text}",
                    binding.editText2.text.toString()
                )

                val options = PhoneAuthOptions.newBuilder(firebaseAuth)
                    .setPhoneNumber("+${binding.editText.text}")
                    .setTimeout(60L, TimeUnit.SECONDS)
                    .setActivity(requireActivity())
                    .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                            Toast.makeText(requireContext(), "OK", Toast.LENGTH_SHORT).show()

                        }

                        override fun onVerificationFailed(p0: FirebaseException) {
                            Toast.makeText(requireContext(), "No", Toast.LENGTH_SHORT).show()
                        }
                    })
            }
        }*/
    }
}