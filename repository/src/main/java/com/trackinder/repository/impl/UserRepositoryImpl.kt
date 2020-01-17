package com.trackinder.repository.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.trackinder.local.UserDao
import com.trackinder.local.model.TokenInfo
import com.trackinder.UserRepository
import com.trackinder.domain.model.*
import com.trackinder.remote.api.UserApi
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao, private val userApi: UserApi) :
    UserRepository {
    override suspend fun saveToken(param: String) {
        userDao.saveToken(TokenInfo(1, param))
    }

    override suspend fun getToken(): LiveData<String> {
        val result = MutableLiveData<String>()
        val value = userDao.getToken()
        result.postValue(value)
        return result
    }

    override suspend fun getProfile(): LiveData<Resource<ResponseUserProfileDomain>> {
        val result = MutableLiveData<Resource<ResponseUserProfileDomain>>()
        result.postValue(Resource(Status.LOADING, null, null))
        try {
            val value = userApi.userProfile()
            result.postValue(Resource(Status.SUCCESS,
                value.let {
                    ResponseUserProfileDomain(
                        it.country!!, it.images?.map {
                            ImagesItemDomain(it!!.width!!, it.url, it.height!!)
                        } ?: listOf(), it.product!!, it.followers?.let {
                            FollowersDomain(it.total!!)
                        }!!, it.href, it.id!!, it.displayName!!, it.type!!, it.externalUrls.let {
                            ExternalUrlsDomain(it?.spotify)
                        }, it.uri!!, it.email!!
                    )
                }, null))
        } catch (e: Exception) {
            e.printStackTrace()
            result.postValue(Resource(Status.ERROR, null, e))
        }
        return result
    }
}