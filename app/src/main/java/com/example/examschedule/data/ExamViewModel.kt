package com.example.examschedule.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExamViewModel(application: Application) : AndroidViewModel(application) {
    private val examDao: ExamDao = AppDatabase.getDatabase(application).examDao()
    val allExams: LiveData<List<Exam>> = examDao.getAllExams().asLiveData()

    fun insertExam(exam: Exam) {
        viewModelScope.launch(Dispatchers.IO) {
            examDao.insertExam(exam)
        }
    }

    fun deleteExam(exam: Exam) {
        viewModelScope.launch(Dispatchers.IO) {
            examDao.deleteExam(exam)
        }
    }
}